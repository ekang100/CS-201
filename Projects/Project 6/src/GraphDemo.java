import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

/**
 * Demonstrates the calculation of shortest paths in the US Highway
 * network, showing the functionality of GraphProcessor and using
 * Visualize
 * To do: Add your name(s) as authors
 */
public class GraphDemo {
    public static void main(String[] args) throws FileNotFoundException, Exception {
        GraphProcessor demoGraph = new GraphProcessor();
        // FileInputStream file = new FileInputStream("data/simple.graph");
        FileInputStream file = new FileInputStream("data/usa.graph");
        FileInputStream citiesFile = new FileInputStream("data/uscities.csv");
        demoGraph.initialize(file);
        // System.out.println("INITIALIZED");

        // Point simplePoint1 = new Point(2.0, 0.0);
        // Point simplePoint2 = new Point(1.0, -1.0);

        Scanner reader = new Scanner(System.in);

        System.out.println("Where are you starting your trip?");
        System.out.print("(Please write latitude): ");
        double[] CityACoords = new double[2];
        CityACoords[0] = reader.nextDouble();
        System.out.print("(Please write longitude): ");
        CityACoords[1] = reader.nextDouble();

        System.out.println("Where are you travelling to?");
        System.out.print("(Please write latitude): ");
        double[] CityBCoords = new double[2];
        CityBCoords[0] = reader.nextDouble();
        System.out.print("(Please write longitude): ");
        CityBCoords[1] = reader.nextDouble();

        Point cityA = new Point(CityACoords[0], CityACoords[1]);
        Point cityB = new Point(CityBCoords[0], CityBCoords[1]);

        double beforeClosestPoints = System.nanoTime();
        // Point nearPoint1 = demoGraph.nearestPoint(simplePoint1);
        // Point nearPoint2 = demoGraph.nearestPoint(simplePoint2);
        Point nearCityA = demoGraph.nearestPoint(cityA);
        Point nearCityB = demoGraph.nearestPoint(cityB);
        double afterClosestPoints = System.nanoTime();
        double timeClosestPoints = (afterClosestPoints - beforeClosestPoints) / 1e6;
        // System.out.println("FOUND CLOSEST POINTS");

        double beforePath = System.nanoTime();
        // List<Point> route = demoGraph.route(nearPoint1, nearPoint2);
        List<Point> route = demoGraph.route(nearCityA, nearCityB);
        double afterPath = System.nanoTime();
        double timePath = (afterPath - beforePath) / 1e6;
        // System.out.println("FOUND PATH");

        long beforeDist = System.nanoTime();
        double distance = demoGraph.routeDistance(route);
        double afterDist = System.nanoTime();
        double timeDist = (afterDist - beforeDist) / 1e6;
        // System.out.println("FOUND DISTANCE");

        // String visFile = "data/simple.vis"; String background = "images/simple.png";
        String visFile = "data/usa.vis"; String background = "images/usa.png";
        Visualize test = new Visualize(visFile, background);
        List<Point> vertices = new ArrayList<>(demoGraph.getVertices());
        List<Point[]> edges = new ArrayList<>(demoGraph.getEdges());
        // System.out.println("FOUND VERTICES AND EDGES");

        // test.drawGraph(vertices, edges);
        test.drawRoute(route);
        // System.out.println("VISUALIZED");

        System.out.println("");
        System.out.println("Nearest point to (" + CityACoords[0] + ", " + CityACoords[1] 
        + ") is " + nearCityA.toString() + ".");
        System.out.println("Nearest point to (" + CityBCoords[0] + ", " + CityBCoords[1] 
        + ") is " + nearCityB.toString() + ".");

        System.out.println("The route distance between " + nearCityA.toString() + 
        " and " + nearCityB.toString() + " is " + distance + "miles");

        // System.out.println("Time to find the closest points:" + timeClosestPoints);
        // System.out.println("Time to find the path:" + timePath);
        // System.out.println("Time to find the distance of the path:" + timeDist);
        double totalTime = timeClosestPoints + timePath + timeDist;
        System.out.println("Total Time = " + totalTime + "ms");
    }
    
}