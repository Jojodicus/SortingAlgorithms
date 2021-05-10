public class Insertion {
    public static void sort(final int[] input) {
        // loop through each element
        for (int i = 1; i < input.length; i++) {
            // swap it to the front until in right place
            for (int j = i; j > 0 && input[j - 1] > input[j]; j--) {
                swap(input, j, j - 1);
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
