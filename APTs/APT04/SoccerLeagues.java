public class SoccerLeagues {
    public int[] points(String[] matches) {
        int n = matches.length;
        int[] points = new int[n];

        for (int i = 0; i < matches.length; i++) {

            char[] matchResults = matches[i].toCharArray();

            for (int j = 0; j < n; j++) {
                char result = matchResults[j];

                if (result == 'W') {
                    points[i] += 3;
                }
                if (result == 'D') {
                    points[i] += 1;
                    points[j] += 1;
                }
                if (result == 'L') {
                    points[j] += 3;
                }
            }
        }

        return points;
    }
}
