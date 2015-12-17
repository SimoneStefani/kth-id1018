/**
 * KTH ID1018 - Programming 1
 * Assignment EU1 (Optional Exercise 1)
 * Created by Simone Stefani on 13/11/15.
 * -----------------------------------------
 * This program return the smallest element
 * of an array.
 */

public class SmallestElement {

    /**
     * The min method returns the least element in a sequential collection.
     * If the collection is empty an IllegalArgumentException is thrown.
     * @param elements is an array of integers
     * @return the smallest number in the array
     * @throws IllegalArgumentException
     */
    public static int min(int[] elements) throws IllegalArgumentException {
        if (elements.length == 0) {
            throw new IllegalArgumentException("Empty collection!");
        }

        // Is used in trace printing 2:
        // int nofIters = 1;
        int[] sequence = elements;
        int nofPairs = sequence.length / 2;
        int nofUnpairedElements = sequence.length % 2;
        int nofPossibleElements = nofPairs + nofUnpairedElements;
        int[] partialSeq = new int[nofPossibleElements];
        int i;
        int j;

        while (sequence.length > 1) {
            // extract a partial sequence of possible elements i = 0;
            i = 0;
            j = 0;

            while (j < nofPairs) {
                partialSeq[j] = (sequence[i] < sequence[i + 1]) ?
                        sequence[i] : sequence[i + 1];
                i += 2;
                j++;
            }

            if (nofUnpairedElements == 1)
                partialSeq[j] = sequence[sequence.length - 1];

            // now turn to the partial sequence
            sequence = partialSeq;
            nofPairs = nofPossibleElements / 2;
            nofUnpairedElements = nofPossibleElements % 2;
            nofPossibleElements = nofPairs + nofUnpairedElements;
            partialSeq = new int[nofPossibleElements]; // <----


            // Trace printing 1 - to follow the sequence
            System.out.println(java.util.Arrays.toString(sequence));
            // Trace printing 2 - to terminate the loop preemptively
            // (to be able to see what happens initially)
            //if (nofIters++ == 10)
            //System.exit (0);
        }

        // sequence[0] is the only remaining possible element
        // - it is the least element
        System.out.println();
        return sequence[0];
    }
}

