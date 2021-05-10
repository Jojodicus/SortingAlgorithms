import java.util.LinkedList;
import java.util.List;

public class RadixBit {
    public static void sort(final int[] input) {
        // initialization
        final byte bits = maxBits(input);
        int exp = 1;
        final List<Integer> l = new LinkedList<>();
        final List<Integer> r = new LinkedList<>();

        // loop through all set bits
        for (int i = 0; i < bits; i++) {
            l.clear();
            r.clear();

            // sort numbers into buckets based on if their bit at i is set
            for (final int in : input) {
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
            for (final Integer sol : l) {
                input[idx] = sol;
                idx++;
            }
        }
    }

    // computes the highest set bit
    private static byte maxBits(final int[] nums) {
        int exp = 1 << 31;
        for (byte i = 32; i > 0; i--) {
            for (final int num : nums) {
                if ((exp & num) != 0)
                    return i;
            }
            exp = exp >>> 1;
        }
        return 0;
    }
}
