import java.util.Locale;
import java.util.Scanner;

/**
 * KTH ID1018 - Programming 1
 * Assignment OU1 (Compulsory Exercise 1)
 * Created by Simone Stefani on 03/11/15.
 * -----------------------------------------
 * Store a data set of temperatures in a matrix
 * and compute min, max and average values.
 */

public class Temperatures {
    public static void main(String[] args) {

        System.out.println("TEMPERATURES\n");

        // Use scanner as input tool and set Locale to US
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);

        // Enter the number of weeks and of measurements per week
        System.out.print("Number of weeks: ");
        int nofWeeks = in.nextInt();
        System.out.print("Number of measurements per week: ");
        int nofMeasurementsPerWeek = in.nextInt();

        // Create a matrix with storage space for temperature data
        double[][] t = new double[nofWeeks + 1][nofMeasurementsPerWeek + 1];

        // Read the temperatures
        for (int week = 1; week <= nofWeeks; week++) {
            System.out.println("Temperatures - week " + week + ":");
            for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++)
                t[week][reading] = in.nextDouble();
        }
        System.out.println();

        // Print out the table with the data
        System.out.println("The temperatures:");
        for (int week = 1; week <= nofWeeks; week++) {
            for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++) {
                System.out.print(t[week][reading] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Create vectors for the least, greatest and average temperature - weekly
        double[] minT = new double[nofWeeks + 1];
        double[] maxT = new double[nofWeeks + 1];
        double[] sumT = new double[nofWeeks + 1];
        double[] avgT = new double[nofWeeks + 1];

        // Calculate min temps by week
        for (int week = 1; week <= nofWeeks; week++) {
            minT[week] = t[week][1];
            for (int read = 2; read <= nofMeasurementsPerWeek; read++) {
                if(t[week][read] < minT[week]) {
                    minT[week] = t[week][read];
                }
            }
        }

        // Calculate max temps by week
        for (int week = 1; week <= nofWeeks; week++) {
            maxT[week] = t[week][1];
            for (int read = 2; read <= nofMeasurementsPerWeek; read++) {
                if(t[week][read] > maxT[week]) {
                    maxT[week] = t[week][read];
                }
            }
        }

        // Calculate sum of temperatures reading by week
        for (int week = 1; week <= nofWeeks; week++) {
            sumT[week] = t[week][1];
            for (int read = 2; read <= nofMeasurementsPerWeek; read++) {
                sumT[week] += t[week][read];
            }
        }

        // Calculate average of temperatures reading by week
        for (int week = 1; week <= nofWeeks; week++) {
            avgT[week] = sumT[week] / nofMeasurementsPerWeek;
        }

        // Show min temps
        System.out.println("The minimum temperatures (by week) are: ");
        for (int week = 1; week <= nofWeeks; week++) {
            System.out.print(minT[week] + " ");
        }
        System.out.println("\n");

        // Show max temps
        System.out.println("The maximum temperatures (by week) are: ");
        for (int week = 1; week <= nofWeeks; week++) {
            System.out.print(maxT[week] + " ");
        }
        System.out.println("\n");

        // Show avg temps
        System.out.println("The average temperatures (by week) are: ");
        for (int week = 1; week <= nofWeeks; week++) {
            System.out.printf("%.1f ", avgT[week]);
        }
        System.out.println("\n");

        // Create variables with least, greatest and average temperature
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];
        double avgTemp;

        // Calculate overall minimum temperature
        for (int week = 2; week <= nofWeeks; week++) {
            if (minT[week] < minTemp) {
                minTemp = minT[week];
            }
        }

        // Calculate overall maximum temperature
        for (int week = 2; week <= nofWeeks; week++) {
            if (maxT[week] > maxTemp) {
                maxTemp = maxT[week];
            }
        }

        // Calculate overall sum of temperatures
        for (int week = 2; week <= nofWeeks; week++) {
            sumTemp += sumT[week];
        }

        // Calculate average of temperatures
        avgTemp = sumTemp / (nofWeeks * nofMeasurementsPerWeek);

        // Print minimum temperature
        System.out.println("The overall minimum temperatures is: " + minTemp + "\n");

        // Print maximum temperature
        System.out.println("The overall maximum temperatures is: " + maxTemp + "\n");

        // Print average temperature
        System.out.printf("The average temperatures is: %.1f", avgTemp);
    }
}

