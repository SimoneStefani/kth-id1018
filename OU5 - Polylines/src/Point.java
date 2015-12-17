/**
 * KTH ID1018 - Programming 1
 * Assignment OU5 (Compulsory Exercise 5)
 * Created by Simone Stefani on 06/11/15.
 * -----------------------------------------
 * Define an object of the class Point and
 * its properties.
 */


public class Point {
    String name;
    int xCoord;
    int yCoord;

    /**
     * Constructor for object of class Point.
     * @param name of the point
     * @param xCoord of the point
     * @param yCoord of the point
     */
    public Point(String name, int xCoord, int yCoord) {
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    /**
     * Return a string in the form (name xCoord yCoord). Ex: (A 2 3)
     * @return a string
     */
    @Override
    public String toString() {
        return "(" + this.name + " " + this.xCoord + " " + this.yCoord + ")";
    }

    /**
     * Cloning constructor creates a copy of a point
     * @param another is the point to be copied
     */
    public Point(Point another) {
        this.name = another.getName();
        this.xCoord = another.getX();
        this.yCoord = another.getY();
    }

    // Return name of the object
    public String getName() {
        return name;
    }

    // Return X coordinate of the object
    public int getX() {
        return xCoord;
    }

    // Return Y coordinate of the object
    public int getY() {
        return yCoord;
    }

    // Set the values for X and Y coordinates
    public void setX(int newCoord) {
        this.xCoord = newCoord;
    }

    public void setY(int newCoord) {
        this.yCoord = newCoord;
    }

    /**
     * Compute the distance to another point with pythagorean theorem.
     * @param second point
     * @return the distance computed
     */
    public double distance(Point second) {
        return Math.sqrt(Math.pow((this.xCoord - second.xCoord), 2) + Math.pow((this.yCoord - second.yCoord), 2));
    }

    /**
     * Check if the coordinates of the point are exactly the same
     * of another point.
     * @param second point
     * @return true if the two points have the same coordinates
     */
    public boolean equals(Point second) {
        boolean equal;
        if (this.xCoord == second.xCoord && this.yCoord == second.yCoord) {
            equal = true;
        } else {
            equal = false;
        }
        return equal;
    }
}
