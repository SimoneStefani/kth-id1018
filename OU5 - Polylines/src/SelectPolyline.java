import java.util.Random;

/**
 * Assignments Code
 * Exercise
 * <p>
 * Created by Simone on 13/12/15.
 */

class SelectPolyline {
    public static final Random rand = new Random();
    public static final int NOF_POLYLINES = 10;

    public static void main (String[] args) {
        // Create a random number of polylines
        Polyline[] polylines = new Polyline[NOF_POLYLINES];
        for (int i = 0; i < NOF_POLYLINES; i++) {
            polylines[i] = randomPolyline();
        }

        for (int i = 0; i < NOF_POLYLINES; i++) {
            System.out.println((i+1) + " - " + polylines[i] + polylines[i].getColour());
        }
        System.out.println();

        // Determine the shortest yellow polyline
        int minLeng = NOF_POLYLINES * 10;
        Polyline shortYellow = new Polyline();


        for (int i = 0; i < NOF_POLYLINES; i++) {
            if (polylines[i].getColour().equals("yellow") && polylines[i].length() < minLeng) {
                shortYellow = polylines[i];
            }
        }

        // Show the selected polyline
        System.out.println("The shortest yellow polyline is: " + shortYellow);
    }


    /**
     * The randomPoint method returns a new Point with a name
     * randomly chosen from the single letters A--Z. Coordinates
     * are random.
     * @return the new point
     */
    public static Point randomPoint() {
        String n = "" + (char)(65 + rand.nextInt(26));
        int x = rand.nextInt(11);
        int y = rand.nextInt(11);

        return new Point (n, x, y);
    }

    /**
     * The method randomPolyline returns a random polyline,
     * with a colour either blue, red, or yellow. The names
     * of the vertices are single letters from the set A--Z.
     * Two vertices can not have the same name.
     * @return the new polyline
     */
    public static Polyline randomPolyline() {
        // Create an empty polyline and add vertices
        Polyline polyline = new Polyline();
        int nofVertices = 2 + rand.nextInt(7);
        int nofSelectedVertices = 0;
        boolean[] selectedNames = new boolean[26];

        // Two vertices can not have the same name
        Point chosenPoint = null;
        char chosenChar = 0;
        int asciiMod;
        while (nofSelectedVertices < nofVertices) {
            chosenPoint = randomPoint();
            chosenChar = chosenPoint.name.charAt(0);
            asciiMod = (int) (chosenChar) - 65;
            if (!selectedNames[asciiMod]) {
                selectedNames[asciiMod] = true;
                polyline.addLast(chosenPoint);
                nofSelectedVertices++;
            }
        }
        polyline.setColour(randomColour());
        return polyline;
    }

    /**
     * Define a random colour between "blue", "red" and "yellow".
     * @return return the colour
     */
    public static String randomColour() {
        String colour;
        int colourCode = rand.nextInt(3);
        if (colourCode == 0) {
            colour = "blue";
        } else if (colourCode == 1) {
            colour = "red";
        } else {
            colour = "yellow";
        }
        return colour;
    }
}

