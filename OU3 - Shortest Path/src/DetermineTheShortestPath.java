import java.util.Scanner;

/**
 * KTH ID1018 - Programming 1
 * Assignment OU3 (Compulsory Exercise 3)
 * Created by Simone Stefani on 06/11/15.
 * -----------------------------------------
 * Determine the shortest path between two points
 * X and Y and through two sets of intermediate stations.
 */

public class DetermineTheShortestPath {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Read number of stations (nodes) in zone 2 and zone 3
        System.out.print("Please, enter the number of stations in zone 2: ");
        int numZ2 = in.nextInt();
        System.out.println();
        System.out.print("Enter the number of stations in zone 3: ");
        int numZ3 = in.nextInt();
        System.out.println();

        // Create storage arrays for the distances
        double[] a = new double[numZ2 + 1];
        double[][] b = new double[numZ2 + 1][numZ3 + 1];
        double[] c = new double[numZ3 + 1];


        // Insert distances of segments
        System.out.println("Please, enter the distance for the following segments.");
        for (int i = 1; i <= numZ2; i++) {
            System.out.printf("X - U" + i + ": ");
            a[i] = in.nextDouble();
        }
        for (int i = 1; i <= numZ2; i++) {
            for (int j = 1; j <= numZ3; j++) {
                System.out.printf("U" + i + " - V" + j + ": ");
                b[i][j] = in.nextDouble();
            }
        }
        for (int j = 1; j <= numZ3; j++) {
            System.out.printf("V" + j + " - Y: ");
            c[j] = in.nextDouble();
        }
        System.out.println();

        // Print the shortest path using the method intermediateStations from the class TheShortestPath
        int[] path = TheShortestPath.intermediateStations(a, b, c);
        System.out.println("The shortest path is: X --> U" + path[1] + " --> V" + path[2] + " --> Y");

        // Print the length of the path using the method length from the class TheShortestPath
        double length = TheShortestPath.length(a, b, c);
        System.out.printf("The length is: %.2f\n", length);

    }
}
