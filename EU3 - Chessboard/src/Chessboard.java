/**
 * KTH ID1018 - Programming 1
 * Assignment EU3 (Optional Exercise 3)
 * Created by Simone Stefani on 16/11/15.
 * -----------------------------------------
 * The class Chessboard contains information
 * about the chessboard and its fields and
 * about the chess pieces
 */

public class Chessboard {


    class Field {
        private char row;
        private byte column;
        private Chesspiece piece = null;
        private boolean marked = false;

        /**
         * Constructor for a specific field (tile),
         * its actions and properties.
         * @param row is the row in the chessboard
         * @param column is the coloumn in the chessboard
         */
        private Field(char row, byte column) {
            this.row = row;
            this.column = column;
        }

        /**
         * Position a specific chess piece on the field
         * setting the "piece" variable of field.
         * @param piece the type of the piece
         */
        private void put(Chesspiece piece) {
            this.piece = piece;
        }

        /**
         * Remove the piece present on the field setting
         * the "piece" variable to null.
         * @return the piece removed
         */
        private Chesspiece take() {
            Chesspiece temp = this.piece;
            this.piece = null;
            return temp;
        }

        /**
         * Set the variable "marked" to true when a field
         * is marked by a chess piece.
         */
        private void mark() {
            this.marked = true;
        }

        /**
         * Set the variable "marked" to false when a field
         * is not marked by a chess piece.
         */
        private void unmark() {
            this.marked = false;
        }

        @Override
        /**
         * Return string "xx" if the field is marked,
         * "--" if it is not marked.
         */
        public String toString() {
            String s = (marked) ? "xx" : "--";
            return (piece == null) ? s : piece.toString();
        }
    }


    // Define main characteristics of chessboard
    public static final int NUMBER_OF_ROWS = 8;
    public static final int NUMBER_OF_COLUMNS = 8;
    public static final int FIRST_ROW = 'a';
    public static final int FIRST_COLUMN = 1;

    // Define variable for a two dimensional array of objects of the type field
    private Field[][] fields;

    /**
     * Create the two dimensional array chessboard. The arrays
     * are filled creating elements of the type fields with suitable
     * row and column properties.
     */
    public Chessboard() {
        fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        char row;
        byte column;

        for (int r = 0; r < NUMBER_OF_ROWS; r++) {
            row = (char)(FIRST_ROW + r);
            column = FIRST_COLUMN;

            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                fields[r][c] = new Field(row, column);
                column++;
            }
        }
    }


    /**
     * Print configuration of the chessboard with rows and columns,
     * marked and unmarked fields. Makes use of StringBuilder.
     * @return a formatted string with the configuration
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   1   2   3   4   5   6   7   8\n\n");
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            char rowName = (char)(FIRST_ROW + i);
            stringBuilder.append(rowName).append("  ");
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                stringBuilder.append(fields[i][j].toString()).append("  ");
            }
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString();
    }

    /**
     * Evaluates if two coordinates (row and column) define a valid
     * field contained in the chessboard.
     * @param row of the field
     * @param column of the field
     * @return true if field is valid, else false
     */
    public boolean isValidField(char row, byte column) {
        return row >= 'a' && row <= 'h' && column > 0 && column <= NUMBER_OF_COLUMNS;
    }



    public abstract class Chesspiece {
        private char color; // w - white, b - black
        private char name; // K - King, Q - Queen, R - Rook, B - Bishop, N - Knight, P - Pawn

        // The piece is created outside the chessboard
        protected char row = 0;
        protected byte column = -1;

        /**
         * Constructor for a new chess piece object.
         * @param color of the piece (white or black)
         * @param name is the type of the piece
         */
        protected Chesspiece(char color, char name) {
            this.color = color;
            this.name = name;
        }

        /**
         * Print string with color and name (es: WR)
         * @return the string
         */
        public String toString() {
            return "" + color + name;
        }

        /**
         * "Move" a piece to a specific field. The element is copied to the field
         * and the original remains.
         * @param row of the target field
         * @param column of the target field
         * @throws NotValidFieldException
         */
        public void moveTo(char row, byte column) throws NotValidFieldException {
            if (!Chessboard.this.isValidField(row, column)) throw new NotValidFieldException("The field " + row + column + " is not valid!");
            this.row = row;
            this.column = column;
            int r = row - FIRST_ROW;
            int c = column - FIRST_COLUMN;
            Chessboard.this.fields[r][c].put(this);
        }

        /**
         * Custom exception to handle the case where the field is not valid.
         */
        public class NotValidFieldException extends Exception {
            public NotValidFieldException(String message){
                super(message);
            }
        }

        /**
         * Make use of the method take() to remove the piece from the field.
         */
        public void moveOut() {
            Chessboard.this.fields[row - FIRST_ROW][column - FIRST_COLUMN].take();
        }

        // These methods are implemented in the subclasses of Chesspiece
        public abstract void markReachableFields();
        public abstract void unmarkReachableFields();
    }



    public class Pawn extends Chesspiece {

        // Constructor for object instance of class Pawn
        public Pawn(char color , char name) {
            super(color, name);
        }

        public void markReachableFields() {
            byte col = (byte)(column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].mark();
            }
        }

        public void unmarkReachableFields () {
            byte col = (byte) (column + 1);
            if (Chessboard.this.isValidField(row, col)) {
                int r = row - FIRST_ROW;
                int c = col - FIRST_COLUMN;
                Chessboard.this.fields[r][c].unmark();
            }
        }
    }

    public class Rook extends Chesspiece {

        // Constructor for object instance of class Rook
        public Rook(char color , char name) {
            super(color, name);
        }

        public void markReachableFields() {
            for (byte col = 1; col <= 8; col++) {
                if (Chessboard.this.isValidField(row, col) && (col != column)) {
                    int r = row - FIRST_ROW;
                    int c = col - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }

            for (char ro = 'a'; ro <= 'h'; ro++) {
                if (Chessboard.this.isValidField(ro, column) && (ro != row)) {
                    int r = ro - FIRST_ROW;
                    int c = column - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }

        }

        public void unmarkReachableFields () {
            for (byte col = 1; col <= 8; col++) {
                if (Chessboard.this.isValidField(row, col) && (col != column)) {
                    int r = row - FIRST_ROW;
                    int c = col - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }

            for (char ro = 'a'; ro <= 'h'; ro++) {
                if (Chessboard.this.isValidField(ro, column) && (ro != row)) {
                    int r = ro - FIRST_ROW;
                    int c = column - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }
        }
    }

    public class Knight extends Chesspiece {

        // Constructor for object instance of class Knight
        public Knight(char color , char name) {
            super(color, name);
        }

        // Possible marked fields
        int[] x = {1, 2, 2, 1, -1, -2, -2, -1, 1, 2};

        public void markReachableFields() {
            for (int i = 0; i < 8; i++) {
                if (Chessboard.this.isValidField((char) (row + x[i]), (byte) (column + x[i+2]))) {
                    int r = (char) (row + x[i]) - FIRST_ROW;
                    int c = (byte) (column + x[i+2]) - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }
        }

        public void unmarkReachableFields () {
            for (int i = 0; i < 8; i++) {
                if (Chessboard.this.isValidField((char) (row + x[i]), (byte) (column + x[i+2]))) {
                    int r = (char) (row + x[i]) - FIRST_ROW;
                    int c = (byte) (column + x[i+2]) - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }
        }
    }

    public class Bishop extends Chesspiece {

        // Constructor for object instance of class Bishop
        public Bishop(char color , char name) {
            super(color, name);
        }

        int[] z = {1, 1, -1, -1, 1};

        public void markReachableFields() {
            for (int i = 1; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Chessboard.this.isValidField((char) (row + i*z[j]),(byte) (column + i*z[j+1]))){
                        int r = (char) (row + i*z[j]) - FIRST_ROW;
                        int c = (byte) (column + i*z[j+1]) - FIRST_COLUMN;
                        Chessboard.this.fields[r][c].mark();
                    }
                }
            }
        }

        public void unmarkReachableFields () {
            for (int i = 1; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Chessboard.this.isValidField((char) (row + i*z[j]),(byte) (column + i*z[j+1]))){
                        int r = (char) (row + i*z[j]) - FIRST_ROW;
                        int c = (byte) (column + i*z[j+1]) - FIRST_COLUMN;
                        Chessboard.this.fields[r][c].unmark();
                    }
                }
            }
        }
    }

    public class Queen extends Chesspiece {

        // Constructor for object instance of class Queen
        public Queen(char color , char name) {
            super(color, name);
        }

        int[] z = {1, 1, -1, -1, 1};

        public void markReachableFields() {
            for (byte col = 1; col <= 8; col++) {
                if (Chessboard.this.isValidField(row, col) && (col != column)) {
                    int r = row - FIRST_ROW;
                    int c = col - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }

            for (char ro = 'a'; ro <= 'h'; ro++) {
                if (Chessboard.this.isValidField(ro, column) && (ro != row)) {
                    int r = ro - FIRST_ROW;
                    int c = column - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }

            for (int i = 1; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Chessboard.this.isValidField((char) (row + i*z[j]),(byte) (column + i*z[j+1]))){
                        int r = (char) (row + i*z[j]) - FIRST_ROW;
                        int c = (byte) (column + i*z[j+1]) - FIRST_COLUMN;
                        Chessboard.this.fields[r][c].mark();
                    }
                }
            }

        }

        public void unmarkReachableFields() {
            byte col;
            for (col = 1; col <= 8; col++) {
                if (Chessboard.this.isValidField(row, col) && (col != column)) {
                    int r = row - FIRST_ROW;
                    int c = col - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }

            char ro;
            for (ro = 'a'; ro <= 'h'; ro++) {
                if (Chessboard.this.isValidField(ro, column) && (ro != row)) {
                    int r = ro - FIRST_ROW;
                    int c = column - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }

            for (int i = 1; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Chessboard.this.isValidField((char) (row + i*z[j]),(byte) (column + i*z[j+1]))){
                        int r = (char) (row + i*z[j]) - FIRST_ROW;
                        int c = (byte) (column + i*z[j+1]) - FIRST_COLUMN;
                        Chessboard.this.fields[r][c].unmark();
                    }
                }
            }

        }
    }

    public class King extends Chesspiece {

        // Constructor for object instance of class King
        public King(char color , char name) {
            super(color, name);
        }

        int[] w = {0, 1, 1, 1, 0, -1, -1, -1, 0, 1};

        public void markReachableFields() {
            for (int i = 0; i < 8; i++) {
                if (Chessboard.this.isValidField((char) (row + w[i]), (byte) (column + w[i + 2]))) {
                    int r = (char) (row + w[i]) - FIRST_ROW;
                    int c = (byte) (column + w[i + 2]) - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }
        }

        public void unmarkReachableFields () {
            for (int i = 0; i < 8; i++) {
                if (Chessboard.this.isValidField((char) (row + w[i]), (byte) (column + w[i + 2]))) {
                    int r = (char) (row + w[i]) - FIRST_ROW;
                    int c = (byte) (column + w[i + 2]) - FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }
        }
    }
}
