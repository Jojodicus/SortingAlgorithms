public class Bubble {
    public static void sort(final int[] input) {
        // flag for premature termination
        int sorted = input.length;

        // loop over array n times
        for (int i = 0; sorted != 1 && i < input.length - 1; i++) {
            // copy to avoid overriding
            final int cache = sorted;

            // last numbers will already be sorted
            for (int j = 0; j < cache - 1; j++) {
                // unsorted pair
                if (input[j] > input[j + 1]) {
                    swap(input, j, j + 1);
                    sorted = j + 1;
                }
            }
        }
    }

    // swaps index a and b
    private static void swap(final int[] input, final int a, final int b) {
        final int cache = input[a];
        input[a] = input[b];
        input[b] = cache;
    }
}
