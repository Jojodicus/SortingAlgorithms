import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    /**
     * length of arrays that get testet {0, 1, ... , length - 1}
     */
    private static final int length = 20;

    /**
     * how many times each sorter gets tested with a shuffled array
     */
    private static final int tries = 20;

    /**
     * @param args name of classes that should be tested (or all if empty)
     */
    public static void main(final String[] args) {
        final Class<?>[] classes;
        if (args.length == 0) { // all algorithms get tested
            classes = new Class[]{Bubble.class, Heap.class, Insertion.class, Merge.class, Quick.class, RadixBit.class, Selection.class};
        } else {
            classes = new Class[args.length];

            // convert String -> Class
            for (int i = 0; i < args.length; i++) {
                try {
                    classes[i] = Class.forName(args[i]);
                } catch (final ClassNotFoundException e) {
                    System.err.println(args[i] + " is not a valid class name");
                }
            }
        }

        // test classes
        for (final Class<?> aClass : classes) {
            if (aClass == null) // arg had invalid name
                continue;

            try {
                test(aClass);
                System.out.println(aClass.getName() + " works correctly (" + tries + " tries)");
            } catch (final NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                System.err.println(e);
            }
        }
    }

    /**
     * @param aClass Class that should be tested
     * @throws NoSuchMethodException when sort method is missing
     * @throws InvocationTargetException if sorting method throws exception
     * @throws IllegalAccessException if sort is inaccessible
     */
    @SuppressWarnings("PrimitiveArrayArgumentToVariableArgMethod") // IntelliJ cant get rid of this warning
    private static void test(final Class<?> aClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // get sorting algorithm
        final Method sort = aClass.getDeclaredMethod("sort", int[].class);

        // prepare array backwards
        final int[] arr = new int[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i - 1;
        }

        // begin testing
        for (int i = 0; i < tries; i++) {
            sort.invoke(new Object(), arr);
            if (!sorted(arr))
                throw new AssertionError(aClass.getName() + " did not sorted properly: " + Arrays.toString(arr));
            shuffle(arr); // last shuffle will be unnecessary
        }
    }

    /**
     * @param input array that should be shuffled
     */
    private static void shuffle(final int[] input) {
        // Fisher-Yates shuffle
        for (int i = input.length - 1; i > 0; i--) {
            swap(input, i, (int) (Math.random() * (i + 1)));
        }
    }

    /**
     * @param input array that gets two indices swapped
     * @param a first swap index
     * @param b second swap index
     */
    private static void swap(final int[] input, final int a, final int b) {
        final int cache = input[a];
        input[a] = input[b];
        input[b] = cache;
    }

    /**
     * @param input array that gets tested
     * @return if array is sorted
     */
    private static boolean sorted(final int[] input) {
        for (int i = 1; i < input.length; i++) {
            if (input[i - 1] > input[i])
                return false;
        }
        return true;
    }
}
