public class Bubble {
    public static void sort(int[] input) {
        // flag for premature termination
        boolean unsorted = true;

        // loop over array n times
        for (int i = 0; unsorted && i < input.length - 1; i++) {
            // reset flag
            unsorted = false;

            // last i numbers will already be sorted
            for (int j = 0; j < input.length - 1 - i; j++) {
                // unsorted pair
                if (input[j] > input[j + 1]) {
                    swap(input, j, j + 1);
                    unsorted = true;
                }
            }
        }
    }

    // swaps index a and b
    private static void swap(int[] input, int a, int b) {
        int cache = input[a];
        input[a] = input[b];
        input[b] = cache;
    }
}
