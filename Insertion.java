public class Insertion {
    @SuppressWarnings("ManualArrayCopy")
    public static void sort(int[] input) {
        // loop through each element
        for (int i = 0; i < input.length; i++) {
            int element = input[i];

            // find its place in sorted par-list
            int place = 0;
            while (place < i) {
                if (element < input[place]) {
                    break;
                }
                place++;
            }

            // shift everything over to make room
            for (int j = i; j > place; j--) {
                input[j] = input[j - 1];
            }
            
            // now it can be inserted
            input[place] = element;
        }
    }
}
