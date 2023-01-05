import java.security.InvalidAlgorithmParameterException;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * Models a weighted graph of latitude-longitude points
 * and supports various distance and routing operations.
 * To do: Add your name(s) as additional authors
 * @author Brandon Fain, Ellie Kang, Jack Davis
 *
 */
public class GraphProcessor {
    /**
     * Creates and initializes a graph from a source data
     * file in the .graph format. Should be called
     * before any other methods work.
     * @param file a FileInputStream of the .graph file
     * @throws Exception if file not found or error reading
     */

    private Map<Point, ArrayList<Point>> aList = new HashMap<>();
    private Map<Integer, Point> myMap = new HashMap<>();
    private int numVert;
    private int numEdges;

    public void initialize(FileInputStream file) throws Exception {
        // TODO: Implement initialize
        Scanner scan = new Scanner(file);
        numVert = scan.nextInt();
        numEdges = scan.nextInt();
        while (scan.hasNextLine()) {
            scan.nextLine();
            for (int i = 0; i < numVert; i++) {
                scan.next();
                double lat = scan.nextDouble();
                double lon = scan.nextDouble();
                Point p = new Point(lat, lon);
                aList.put(p, new ArrayList<Point>());
                myMap.put(i, p);
                scan.nextLine();

            }

            for (int j = 0; j < numEdges; j++) {
                Point start = myMap.get(scan.nextInt());
                Point end = myMap.get(scan.nextInt());
                aList.get(start).add(end);
                if (scan.hasNextLine()) {
                    scan.nextLine();
                }
            }
                    
        }
        scan.close();
        
        for (Point p : aList.keySet()) {
            for (Point p2 : aList.get(p)) {
                if (!aList.get(p2).contains(p)) {
                    aList.get(p2).add(p);

                }
            }
        }
    }


    /**
     * Searches for the point in the graph that is closest in
     * straight-line distance to the parameter point p
     * @param p A point, not necessarily in the graph
     * @return The closest point in the graph to p
     */
    public Point nearestPoint(Point p) {
        // TODO: Implement nearestPoint
        Map<Point, Double> distMap = new HashMap<>();
        for (Point pt : aList.keySet()) {
            Double dist = p.distance(pt);
            distMap.put(pt, dist);
        }

        List<Map.Entry<Point, Double>> distList = new LinkedList<Map.Entry<Point, Double>> (distMap.entrySet());
        Collections.sort(distList, (a, b) -> a.getValue().compareTo(b.getValue()));
        Map<Point, Double> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Point, Double> elem : distList) {
            sortedMap.put(elem.getKey(), elem.getValue());
        }

        Map.Entry<Point, Double> entry = sortedMap.entrySet().iterator().next();

        return entry.getKey();
    }


    /**
     * Calculates the total distance along the route, summing
     * the distance between the first and the second Points, 
     * the second and the third, ..., the second to last and
     * the last. Distance returned in miles.
     * @param start Beginning point. May or may not be in the graph.
     * @param end Destination point May or may not be in the graph.
     * @return The distance to get from start to end
     */
    public double routeDistance(List<Point> route) {
        // TODO Implement routeDistance
        Double dist = 0.0;
        for (int i = 0; i < route.size() - 1; i++) {
            Point p1 = route.get(i);
            Point p2 = route.get(i + 1);
            dist += p1.distance(p2);
        }
        return dist;
    }
    

    /**
     * Checks if input points are part of a connected component
     * in the graph, that is, can one get from one to the other
     * only traversing edges in the graph
     * @param p1 one point
     * @param p2 another point
     * @return true if p2 is reachable from p1 (and vice versa)
     */
    public boolean connected(Point p1, Point p2) {
        // TODO: Implement connected
        Queue<Point> toExplore = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        Point current = p1;
        visited.add(current);
        toExplore.add(current);
        while (!toExplore.isEmpty()) {
            current = toExplore.remove();
            for (Point neighbor : aList.get(current)) {
                if (neighbor.equals(p2)) {
                    return true;
                }
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    toExplore.add(neighbor);

                }
            }
        }

        return false;
    }


    /**
     * Returns the shortest path, traversing the graph, that begins at start
     * and terminates at end, including start and end as the first and last
     * points in the returned list. If there is no such route, either because
     * start is not connected to end or because start equals end, throws an
     * exception.
     * @param start Beginning point.
     * @param end Destination point.
     * @return The shortest path [start, ..., end].
     * @throws InvalidAlgorithmParameterException if there is no such route, 
     * either because start is not connected to end or because start equals end.
     */
    public List<Point> route(Point start, Point end) throws InvalidAlgorithmParameterException {
        // TODO: Implement route
        
        if (!connected(start, end) || start.equals(end)) {
            throw new InvalidAlgorithmParameterException();
        }

        Map<Point, Double> distance = new HashMap<>();
        Comparator<Point> comp = (a, b) -> distance.get(a).intValue() - distance.get(b).intValue();
        PriorityQueue<Point> toExplore = new PriorityQueue<>(comp);
        Map<Point, Point> previous = new HashMap<>();
        Stack<Point> path = new Stack<>();

        Point current = start;
        distance.put(current, 0.0);
        toExplore.add(current);

        while (!toExplore.isEmpty()) {
            current = toExplore.remove();
            if (current.equals(end)) {
                break;
            }
            for (Point neighbor : aList.get(current)) {
                Double weight = current.distance(neighbor);
                if (!distance.containsKey(neighbor)
                || distance.get(neighbor) > distance.get(current) + weight) {
                    distance.put(neighbor, distance.get(current) + weight);
                    previous.put(neighbor, current);
                    toExplore.add(neighbor);
                }
            }
        }
        path.push(end);
        Point p = previous.get(end);
        path.push(p);
        while (previous.get(p) != null) {
            p = previous.get(p);
            path.push(p);
        }
        if (!path.contains(start)) {
            path.push(start);
        }
        List<Point> ret = new ArrayList<>(path);
        Collections.reverse(ret);

        return ret;
    }


    public Set<Point> getVertices() {
        return aList.keySet();
    }


    public List<Point[]> getEdges() {
        List<Point[]> edges = new ArrayList<>();

        for (Map.Entry<Point, ArrayList<Point>> set : aList.entrySet()) {
            Point p = set.getKey();
            ArrayList<Point> pList = set.getValue();
            for (Point p2 : pList) {
                Point[] pArr = new Point[2];
                pArr[0] = p;
                pArr[1] = p2; 
                edges.add(pArr);
            }
        }
        return edges;
    }

}
