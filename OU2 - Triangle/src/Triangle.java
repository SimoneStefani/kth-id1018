/**
 * KTH ID1018 - Programming 1
 * Assignment OU2 (Compulsory Exercise 2)
 * Created by Simone Stefani on 05/11/15.
 * -----------------------------------------
 * A set of methods that compute the properties
 * of a triangle.
 */

public class Triangle {

    /**
     * Compute the perimeter of a triangle given the sides.
     * @param side1
     * @param side2
     * @param side3
     * @return the perimeter of the triangle
     */
    public static double compPerim(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }


    /**
     * Compute the area of a triangle given th base and the height.
     * @param base
     * @param height
     * @return the area of the triangle
     */
    public static double compArea(double base, double height) {
        return (base * height) / 2;
    }


    /**
     * Compute the area of a triangle with Heron's formula.
     * @param side1
     * @param side2
     * @param side3
     * @return the area of the triangle
     */
    public static double heron(double side1, double side2, double side3) {
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    /**
     * Computes the bisectors ofa triangle given sides and angles.
     */
    public static double[] bisector(double a, double b, double c, double alpha, double beta, double gamma) {
        double[] sides = {a,b,c,a};
        double[] angles= {gamma,alpha,beta};
        double[] bis = new double[3];
        for (int i = 0; i < 3; i++) {
            double p = 2 * sides[i] * sides[i+1] * Math.cos(angles[i] / 2);
            bis[i] = p / (sides[i] + sides[i+1]);
        }
        return bis;
    }


    /**
     * Computes the radius of the incircle given the sides of the triangle.
     * @param side1
     * @param side2
     * @param side3
     * @return the radius of the incircle.
     */
    public static double rInc(double side1, double side2, double side3) {
        // Calculate area of triangle
        double area = heron(side1, side2, side3);
        // Calculate perimeter of triangle
        double perim = compPerim(side1, side2, side3);

        // Compute radius of incircle of the triangle
        return (2 * area) / perim;
    }

    /**
     * Computes the radius of the circumcircle given the sides of the triangle.
     * @param side1
     * @param side2
     * @param side3
     * @return the radius of the incircle.
     */
    public static double rCir(double side1, double side2, double side3) {
        // Calculate area of triangle
        double area = heron(side1, side2, side3);

        // Compute radius of circumcircle of the triangle
        return (side1*side2*side3)/(4 * area);
    }
}
