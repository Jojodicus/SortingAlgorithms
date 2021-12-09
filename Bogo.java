public class Bogo {
    public static boolean isSorted(int[] input) {
        for (int i = 1; i < input.length; i++) {
            if (input[i - 1] > input[i])
                return false;
        }
        return true;
    }

    private static void shuffle(int[] input) {
        // Fisher-Yates shuffle
        for (int i = input.length - 1; i > 0; i--) {
            swap(input, i, (int) (Math.random() * (i + 1)));
        }
    }

    private static void swap(int[] input, int a, int b) {
        int cache = input[a];
        input[a] = input[b];
        input[b] = cache;
    }

    public static void sort(int[] input) {
        while (!isSorted(input))
            shuffle(input);
    }
}
