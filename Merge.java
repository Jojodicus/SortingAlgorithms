public class Merge {
    public static void sort(int[] input) {
        // initialize
        mergesort(input, 0, input.length - 1);
    }

    private static void mergesort(int[] list, int start, int end) {
        // trivial base case
        if(start >= end)
            return;

        // find mid index while avoiding overflows
        int mid = start + ((end - start) / 2);

        // sort two halves
        mergesort(list, start, mid);
        mergesort(list, mid + 1, end);

        // merge two halves
        merge(list, start, mid, end);
    }

    @SuppressWarnings("ManualArrayCopy")
    private static void merge(int[] list, int start, int mid, int end) {
        // initialize arrays
        int[] left = new int[mid - start + 1];
        int[] right = new int[end - mid];

        for (int i = 0; i < left.length; i++) {
            left[i] = list[i + start];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = list[i + mid + 1];
        }

        // reuse mid and end variables for lower and upper index
        // start is used to keep track of where to copy to
        mid = 0; // lower
        end = 0; // upper

        // while both arrays have elements
        while (mid < left.length && end < right.length) {
            // copy the smaller one over
            if (left[mid] > right[end]) {
                list[start] = right[end];
                end++;
            } else {
                list[start] = left[mid];
                mid++;
            }

            // continue with next index
            start++;
        }

        // left still has elements
        while (mid < left.length) {
            list[start] = left[mid];
            start++;
            mid++;
        }

        // right still has elements
        while (end < right.length) {
            list[start] = right[end];
            start++;
            end++;
        }
    }
}
