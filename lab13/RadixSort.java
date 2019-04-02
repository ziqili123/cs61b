/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        int max = Integer.MIN_VALUE;
        for (String i : asciis) {
            max = max > i.length() ? max : i.length();
        }
        String[] result = asciis;

        for (int j = max - 1; j >= 0; j--) {
            sortHelperLSD(result, j);
        }
        return result;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
     * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        int[] count = new int[257];
        String[] aux = new String[asciis.length];
        for (int i = 0; i < asciis.length; i++) {
            if (index > asciis[i].length() - 1) {
                count[0]++;
            } else {
                count[(int)asciis[i].charAt(index) + 1]++;
            }

        }
        for (int r = 0; r < 256; r++) {
            count[r + 1] += count[r];
        }
        for (int i = 0; i < asciis.length; i++) {
            if (index > asciis[i].length() - 1) {
                aux[count[0]++] = asciis[i];
            } else {
                aux[count[asciis[i].charAt(index)]++] = asciis[i];
            }

        }
        for (int i = 0; i < asciis.length; i++) {
            asciis[i] = aux[i];
        }



    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
    public static void main(String[] args) {
        String[] result = new String[3];
        result[0] = "nad";
        result[1] = "casd";
        result[2] = "dsd";
        sort(result);
        for (String i : result) {
            System.out.println(i);
        }
    }
}
