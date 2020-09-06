package qianxi.library;

import java.io.IOException;

/**
 * @author
 */
public class Sort {
    public static void main(String[] args) throws IOException {
        Comparable[] a = new Comparable[]{0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        show(a);
        //        selectSort(a);
        //        insertSort(a);
        shellSort(a);
        show(a);
    }


    @Deprecated
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) <= 0;
    }

    /**
     * ascending  it means that a[i-1]<=a[i]
     * loe means that {v} less than or equal to {w}
     *
     * @param v
     * @param w
     * @return if {v}<={w} true, else false
     */
    public static boolean loe(Comparable v, Comparable w) {
        return v.compareTo(w) <= 0;
    }

    /**
     * descending it means that a[i-1]>=a[i]
     * goe means that {v} greater than or equal to {w}
     *
     * @param v
     * @param w
     * @return if {v}>={w} true, else false
     */
    public static boolean goe(Comparable v, Comparable w) {
        return v.compareTo(w) >= 0;
    }

    /**
     * exchange two element of the Comparable[]{a} by index {i}&{j}
     *
     * @param a Comparable[]
     * @param i {a}[{i}]
     * @param j {a}[{j}]
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * printArr all element of  the Comparable[]{a}
     *
     * @param a Comparable[]
     */
    public static void show(Comparable[] a) {
        for (Comparable c : a) {System.out.print(c + " ");}
        System.out.println();
    }

    /**
     * judge ascending sort, it means that {a}[i-1]<={a}[i]
     * if all the elements are the same, return {true}
     *
     * @param a Comparable[]
     * @return if ascending order true, else false
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; ++i) {
            // if not ascending return false
            if (!loe(a[i - 1], a[i])) { return false; }
        }
        return true;
    }

    public static void bubbleSort(int[] a) { }

    public static void quickSort(int[] a, int low, int high) { }

    public static void mergeSort(int[] a, int low, int high) { }

    public static void selectSort(Comparable[] a) {
        for (int i = 0; i < a.length - 1; ++i) {
            // the index that records smaller values, that means {a}[{index}]<={a}[i]
            int index = i;
            for (int j = i + 1; j < a.length; ++j) {
                // if not {a}[{index}] <= {a}[j] do index=j
                if (!loe(a[index], a[j])) { index = j; }
            }
            if (index != i) { exch(a, index, i); }
        }
    }

    public static void insertSort(Comparable[] a, int lo, int hi) {
        for (int i = 1; i < a.length; ++i) {
            for (int j = i; j >= 1 && goe(a[j - 1], a[j]); --j) {
                // if j>=1 &&  a[j-1]>=a[j] exchange them
                exch(a, j, j - 1);
            }
        }
    }

    /**
     * is the array h-sorted?
     *
     * @param a
     * @param h
     * @return
     */
    private static boolean isHsorted(Comparable[] a, int h) {
        for (int i = h; i < a.length; i++) {
            if (less(a[i], a[i - h])) { return false; }
        }
        return true;
    }

    /**
     * @param a
     */
    public static void shellSort(Comparable[] a) {
        final int N = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < N / 3) { h = 3 * h + 1; }

        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < N; ++i) {
                for (int j = i; j >= h && goe(a[j - h], a[j]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            // run to here, step size H orderly
            assert isHsorted(a, h);
            h /= 3;
        }
        assert isSorted(a);
    }
}
