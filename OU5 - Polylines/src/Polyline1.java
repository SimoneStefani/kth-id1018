/**
 * KTH ID1018 - Programming 1
 * Assignment OU5 (Compulsory Exercise 5)
 * Created by Simone Stefani on 06/11/15.
 * -----------------------------------------
 * Variation of the class polyline: the references to
 * objects are copied instead of the objects themselves.
 */

public class Polyline1 {
    private Point[] vertices;
    private String colour = "black";
    private int width = 1;

    /**
     * Constructor of an empty polyline.
     */
    public Polyline1() {
        this.vertices = new Point[0];
    }

    /**
     * Constructor of a polyline with given vertices.
     * @param vertices is an array of Point objects
     */
    public Polyline1(Point[] vertices) {
        this.vertices = new Point[vertices.length];
        for (int i = 0; i < this.vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    /**
     * Return a string of points in the form: (A 1 2) (B 3 4) (C 5 6).
     * @return the string
     */
    public String toString() {
        StringBuilder description = new StringBuilder();
        for (Point vertex : this.vertices) {
            description.append("(" + vertex.name + " " + vertex.xCoord + " " + vertex.yCoord + ") ");
        }
        return description.toString();
    }


    /**
     * Get the vertices of the polyline. The references are copied.
     * @return an array of Point objects
     */
    public Point[] getVertices() {
        return vertices;
    }

    // Return the color of the polyline
    public String getColour() {
        return this.colour;
    }

    // Return the width  of the polyline
    public int getWidth() {
        return this.width;
    }

    // Set colour of the polyline
    public void setColour(String colour) {
        this.colour = colour;
    }

    // Set the width of the polyline
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Compute the length of a polyline summing all the lengths
     * of the segments that connect two points.
     * @return the total length of a polyline
     */
    public double length() {
        double leng = 0;
        for (int i = 0; i < this.vertices.length - 1; i++) {
            leng += this.vertices[i].distance(this.vertices[i + 1]);
        }
        return leng;
    }

    /**
     * Add a new vertex at the end of the polyline.
     * @param vertex the point to be added
     */
    public void addLast(Point vertex) {
        Point[] h = new Point[this.vertices.length + 1];
        int i;
        for (i = 0; i < this.vertices.length; i++) {
            h[i] = this.vertices[i];
        }
        h[i] = new Point(vertex);
        this.vertices = h;
    }

    /**
     * Add a new vertex before a specific point.
     * @param vertex the point to be added
     * @param vertexName the name of the vertex after the insertion point
     */
    public void addBefore(Point vertex, String vertexName) {
        Point[] newVertices = new Point[this.vertices.length + 1]; // Create an array one index longer than vertices

        // Loop until the name provided shows up
        int i = 0;
        while (!((this.vertices[i].name).equals(vertexName))) {
            newVertices[i] = this.vertices[i];
            i++;
        }
        // Add newVertex
        newVertices[i] = new Point(vertex);
        // Complete the array with the remaining elements
        for (int j = i + 1; j <= this.vertices.length; j++) {
            newVertices[j] = this.vertices[j + 1];
        }
        this.vertices = newVertices;
    }

    /**
     * Iterator for the class polyline. Implements methods
     * hasVertex(), vertex() and advance().
     */
    public class PolylineIterator {
        private int current = -1;

        public PolylineIterator() {
            if (Polyline1.this.vertices.length > 0)
                current = 0;
        }

        public boolean hasVertex() {
            return current != -1;
        }

        public Point vertex() throws java.util.NoSuchElementException {
            if (!this.hasVertex())
                throw new java.util.NoSuchElementException("end of iteration");

            Point vertex = Polyline1.this.vertices[current];

            return vertex;
        }

        public void advance() {
            if (current >= 0 && current < Polyline1.this.vertices.length - 1)
                current++;
            else
                current = -1;
        }
    }
}
