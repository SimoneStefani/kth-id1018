import java.util.Scanner;

/**
 * KTH ID1018 - Programming 1
 * Assignment OU2 (Compulsory Exercise 2)
 * Created by Simone Stefani on 05/11/15.
 * -----------------------------------------
 * Compute the radii of the incircle and circumcircle
 * of a triangle with sides provided by the user.
 */

public class TriangleAndItsCircles {
    public static void main(String[] args) {

        // Read the sides' values from keyboard
        Scanner in = new Scanner(System.in);
        System.out.println("Please, enter the length of the sides of the triangle:");
        double side1 = in.nextDouble();
        double side2 = in.nextDouble();
        double side3 = in.nextDouble();

        System.out.println();

        // Print radius incircle
        double raInc = Triangle.rInc(side1, side2, side3);
        System.out.printf("The radius of the incircle of the triangle is: %.2f\n\n", raInc);

        // Print radius circumcircle
        double raCir = Triangle.rCir(side1, side2, side3);
        System.out.printf("The radius of the circumcircle of the triangle is: %.2f\n", raCir);
    }
}
