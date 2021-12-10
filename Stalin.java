public class Stalin {
    private static final int FILL = Integer.MAX_VALUE;

    public static void sort(int[] input) {
        // eliminate political enemies
        for (int i = input.length - 1; i > 0; --i) {
            if (input[i - 1] > input[i])
                input[i] = Integer.MAX_VALUE;
        }
        // bring everyone else in line
        int j = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] != Integer.MAX_VALUE) {
                input[j] = input[i];
                j++;
            }
        }
        // fill up the gulag
        for (; j < input.length; j++)
            input[j] = FILL;
    }
}
