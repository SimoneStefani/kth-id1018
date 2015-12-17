/**
 * KTH ID1018 - Programming 1
 * Assignment OU3 (Compulsory Exercise 3)
 * Created by Simone Stefani on 06/11/15.
 * -----------------------------------------
 * Method to determine the stations of the shortest
 * path and its length.
 */

class TheShortestPath {

    /**
     * The method intermediateStations returns a vector of the
     * intermediate stations that are on the shortest path.
     * The ordinal number of the first station is located in
     * index 1 of the vector, and the second station on index 2.
     * @param a array of lengths
     * @param b matrix of lengths
     * @param c array of lengths
     * @return a vector with the intermediate stations
     */
    public static int[] intermediateStations(double[] a, double[][] b, double[] c) {
        int[] intStations = {0, 1, 1};
        double minLeng = a[1] + b[1][1] + c[1];

        // Loop through all the possible paths in search of the shortest
        // British museum algorithm used with update strategy
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < c.length; j++) {
                double curLeng = a[i] + b[i][j] + c[j];

                if (curLeng < minLeng) {
                    intStations[1] = i;
                    intStations[2] = j;
                    minLeng = curLeng;
                }
            }
        }
        return intStations;
    }


    /**
     * The method length returns the length of the shortest path.
     * @param a array of lengths
     * @param b matrix of lengths
     * @param c array of lengths
     * @return the length of shortest path.
     */
    public static double length (double[] a, double[][] b, double[] c) {
        int[] s = intermediateStations(a, b, c);
        return a[s[1]] + b[s[1]][s[2]] + c[s[2]];
    }
}
