public class Heap {
    public static void sort(int[] input) {
        // build heap from back
        for (int i = input.length / 2; i >= 0; i--) {
            reheap(input, i, input.length);
        }

        // build sorted array from back
        for (int i = input.length - 1; i > 0; i--) {
            swap(input, 0, i);
            reheap(input, 0, i);
        }
    }

    // reheap as max-heap
    private static void reheap(int[] heap, int start, int end) {
        int biggest = start;

        // left and right child indices
        int left = 2 * start + 1;
        int right = 2 * start + 2;

        // check if left is bigger
        if (left < end && heap[left] > heap[biggest])
            biggest = left;

        // check if right is bigger
        if (right < end && heap[right] > heap[biggest])
            biggest = right;

        // check if biggest has changed
        if (biggest == start)
            return;

        // reheap needed - swap and recurse
        swap(heap, start, biggest);
        reheap(heap, biggest, end);

    }

    // swaps index a and b
    private static void swap(int[] input, int a, int b) {
        int cache = input[a];
        input[a] = input[b];
        input[b] = cache;
    }
}
