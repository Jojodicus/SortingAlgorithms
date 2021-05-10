public class Quick {
    public static void sort(final int[] input) {
        quicksort(input, 0, input.length - 1);
    }

    private static void quicksort(final int[] input, final int start, final int end) {
        // recursion base case
        if (end <= start)
            return;

        // partition and get pivot position
        final int pivot = partition(input, start, end);

        // repeat for the two sub-partitions
        quicksort(input, start, pivot - 1);
        quicksort(input, pivot + 1, end);

    }

    private static int partition(final int[] input, final int start, final int end) {
        // pivot is last element
        final int pivot = input[end];

        // pivot position
        int i = start;

        // loop through current partition
        for (int j = start; j < end; j++) {

            // check if current belongs to front
            if (input[j] < pivot) {
                // move element to pivot position and increment pivot index
                swap(input, i, j);
                i++;
            }
        }

        // get pivot to right place and return it
        swap(input, i, end);
        return i;
    }

    // swaps index a and b
    private static void swap(final int[] input, final int a, final int b) {
        final int cache = input[a];
        input[a] = input[b];
        input[b] = cache;
    }
}
