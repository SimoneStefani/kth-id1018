/**
 * KTH ID1018 - Programming 1
 * Assignment OU5 (Compulsory Exercise 5)
 * Created by Simone Stefani on 06/11/15.
 * -----------------------------------------
 * Test for the class Polyline.
 */

import java.util.Scanner;

public class PolylineTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Point p1 = new Point("A", 3, 4);
        Point p2 = new Point("B", 5, 6);
        Point p3 = new Point("C", 8, 2);
        Point p4 = new Point("D", 4, 1);
        Point p5 = new Point("E", 7, 9);
        System.out.println(p1 + " " + p2 + " " + p3);
        System.out.println();

        // Create polyline objects
        Point[] pointVec = {p1, p2, p3};
        Polyline pol1 = new Polyline(pointVec);

        // Test get and set colour methods
        System.out.println("Current colour is: " + pol1.getColour());
        System.out.print("Enter new colour: ");
        pol1.setColour(in.next());
        System.out.println("Current colour is: " + pol1.getColour());
        System.out.println();

        // Test get and set width methods
        System.out.println("Current width is: " + pol1.getWidth());
        System.out.print("Enter new width: ");
        pol1.setWidth(in.nextInt());
        System.out.println("Current width is: " + pol1.getWidth());
        System.out.println();

        // Return polyline length
        System.out.println("Polyline length: " + pol1.length());
        System.out.println();


        System.out.println("Adding point D at the end");
        pol1.addLast(p4);
        System.out.println(pol1);
        System.out.println();

        System.out.println("Adding point E before C");
        pol1.addBefore(p5, "C");
        System.out.println(pol1);
        System.out.println();

        System.out.println("Removing point D");
        pol1.remove("B");
        System.out.println(pol1);
        System.out.println();



        Polyline.PolylineIterator polyIter = pol1.new PolylineIterator();
        while (polyIter.hasVertex()) {
            System.out.println(polyIter.vertex());
            polyIter.advance();
        }
    }
}
