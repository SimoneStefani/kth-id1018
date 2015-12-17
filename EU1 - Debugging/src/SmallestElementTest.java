/**
 * KTH ID1018 - Programming 1
 * Assignment EU1 (Optional Exercise 1)
 * Created by Simone Stefani on 13/11/15.
 * -----------------------------------------
 * This program test the SmallestElement class
 */

public class SmallestElementTest {
    public static void main(String[] args) {
        int[] test1 = {4,5,12,8,7,6,14,3,2,9,1,17,13,21,11,10};
        int[] test2 = {11,3,7,18,24,12,36,2,6,8,16,15,9,4,10,27,1,28,13};

        System.out.println(SmallestElement.min(test1));
        System.out.println();
        System.out.println(SmallestElement.min(test2));
    }
}
