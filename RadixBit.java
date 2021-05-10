import java.util.LinkedList;
import java.util.List;

public class RadixBit {
    public static void sort(int[] input) {
        // initialization
        byte bits = maxBits(input);
        int exp = 1;
        List<Integer> l = new LinkedList<>();
        List<Integer> r = new LinkedList<>();

        // loop through all set bits
        for (int i = 0; i < bits; i++) {
            l.clear();
            r.clear();

            // sort numbers into buckets based on if their bit at i is set
            for (int in : input) {
                if ((in & exp) == 0)
                    l.add(in);
                else
                    r.add(in);
            }

            // shift over to next bit
            exp = exp << 1;

            // merge buckets
            l.addAll(r);

            // reconstruct input
            int idx = 0;
            for (Integer sol : l) {
                input[idx] = sol;
                idx++;
            }
        }
    }

    // computes the highest set bit
    private static byte maxBits(int[] nums) {
        int exp = 1 << 31;
        for (byte i = 32; i > 0; i--) {
            for (int num : nums) {
                if ((exp & num) != 0)
                    return i;
            }
            exp = exp >>> 1;
        }
        return 0;
    }
}
