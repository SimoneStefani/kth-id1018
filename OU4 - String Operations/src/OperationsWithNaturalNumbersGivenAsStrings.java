import java.util.Scanner;

import static java.lang.System.out;

/**
 * Assignments Code
 * Exercise
 * <p>
 * Created by Simone on 12/12/15.
 */

class OperationsWithNaturalNumbersGivenAsStrings {
    public static void main(String[] args) {
        out.println("OPERATIONS ON NATURAL NUMBERS IN CHARACTER STRINGS");

        // enter two natural numbers
        Scanner in = new Scanner(System.in);
        out.println("two natural numbers:");
        String num1 = in.next();
        String num2 = in.next();
        out.println();

        // add the numbers and show the result
        String sum = add(num1, num2);
        show(num1, num2, sum, '+');

        // subtract the numbers and show the result
        String difference = subtract(num1, num2);
        show(num1, num2, difference, '-');
    }


    /**
     * Add two numbers in form of strings.
     * @param num1 addend
     * @param num2 addend
     * @return the sum in form of a string
     */
    public static String add(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int carry = 0;

        // Prepare numbers with right format for addition
        if (num1.length() > num2.length()) {
            num2 = sameLength(num1, num2);
        } else if (num2.length() > num1.length()) {
            num1 = sameLength(num2, num1);
        }

        // Make addition considering every single char as an int
        for (int i = num1.length() - 1; i >= 0; i--) {
            int fig1 = Character.getNumericValue(num1.charAt(i));
            int fig2 = Character.getNumericValue(num2.charAt(i));
            int partSum = fig1 + fig2 + carry;
            carry = partSum / 10;
            partSum = partSum % 10;
            sum.append(String.valueOf(partSum));
        }
        if (carry == 1) {
            sum.append(String.valueOf(carry));
        }
        sum.reverse();
        return sum.toString();
    }


    /**
     * The subtract method accepts two natural numbers
     * represented as character strings and returns their
     * difference as a character string.
     * The first number is not smaller than the second
     * @param num1 minuend
     * @param num2 subtrahend
     * @return
     */
    public static String subtract(String num1, String num2) {
        StringBuilder diff = new StringBuilder();
        int carry = 0;

        // Prepare numbers with right format for subtraction
        if (num1.length() > num2.length()) {
            num2 = sameLength(num1, num2);
        }

        // Make subtraction considering every single char as an int
        for (int i = num1.length() - 1; i >= 0; i--) {
            int fig1 = Character.getNumericValue(num1.charAt(i)) - carry;
            int fig2 = Character.getNumericValue(num2.charAt(i));
            int partDiff;
            if (fig1 >= fig2) {
                partDiff = fig1 - fig2;
                carry = 0;
            } else {
                partDiff = (fig1 + 10) - fig2;
                carry = 1;
            }
            diff.append(String.valueOf(partDiff));
        }
        diff.reverse();
        return diff.toString();
    }


    /**
     * The show method presents two natural numbers, an
     * operator and the result string.
     * @param num1 first number
     * @param num2 second number
     * @param result of the operation
     * @param operator the symbol of the operation
     */
    public static void show(String num1, String num2, String result, char operator) {
        // set an appropriate length on numbers and result
        int len1 = num1.length();
        int len2 = num2.length();
        int len = result.length();
        int maxLen = Math.max(Math.max(len1, len2), len);
        num1 = setLen(num1, maxLen - len1);
        num2 = setLen(num2, maxLen - len2);
        result = setLen(result, maxLen - len);

        // show the expression
        out.println(" " + num1);
        out.println("" + operator + "" + num2);
        for (int i = 0; i < maxLen + 2; i++) {
            out.print("-");
        }
        out.println();
        out.println(" " + result + "\n");
    }


    /**
     * The setLen method prepends the supplied number of
     * spaces at the beginning of a string
     * @param s is the number's string
     * @param nofSpaces to add
     * @return the number with the spaces
     */
    public static String setLen(String s, int nofSpaces) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < nofSpaces; i++)
            sb.insert(0, " ");
        return sb.toString();
    }

    /**
     * Add zeros in front of a number's string
     * @param major the greatest number
     * @param minor the smallest number
     * @return the smallest number with zeros
     */
    private static String sameLength(String major, String minor) {
        int diff = major.length() - minor.length();
        for (int i = 0; i < diff; i++) {
            minor = "0" + minor;
        }
        return minor;
    }
}

