package sort;

import java.util.Arrays;

/**
 *  @author qianxi
 *  @email qianx@hopshine.net
 *  @date 2020/9/4
 *  @copyright ©2020 All Right Reserved
 *  @description
 * only sort an array of integers
 */

public class Sort {
    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(1000);
        int[] iArr = {0, 2, 4, 6, 1, 3, 5, 7};
        printArr(iArr);
        //        bubbleSort(iArr);
        quickSort(iArr, 0, iArr.length - 1);
        //        mergeSort(iArr, 0, iArr.length - 1);
        //        merge(iArr);
        printArr(iArr);
    }

    public Sort() { }

    public static void printArr(int[] iArr) {
        System.out.println(Arrays.toString(iArr));
    }


    /**
     * swap two integers with xor
     * there is one caveat that a^a=0
     *
     * @param a int[]
     * @param i index a[i]
     * @param j index a[j]
     */
    public static void swap(int[] a, int i, int j) {
        // caveat: i^i=0
        if (a[i] == a[j]) {return;}
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
    }

    /**
     * bubble sort
     *
     * @param a int[]
     */
    public void bubbleSort(int[] a) {
        for (int bub = 0; bub < a.length - 1; ++bub) {
            // every time limit from arr.length-1 to 1
            for (int i = 0; i < a.length - 1 - bub; ++i) {
                // if a[i]>a[i+1] exchange them
                if (a[i] <= a[i + 1]) { swap(a, i, i + 1); }
            }
        }
    }

    /**
     * quick sort
     *
     * @param a  int[]
     * @param lo include a[lo]
     * @param hi include a[hi]
     */
    public static void quickSort(int[] a, int lo, int hi) {
        // [lo,hi] mean that contain lo, hi
        // {lo} must less than {hi}
        if (lo >= hi) {return;}
        int l = lo, h = hi;
        int key = a[lo]; // 1)
        while (l < h) {
            // find element that greater than key from {hi} to {lo}
            while (l < h && key <= a[h]) { --h; }
            // find element that less than key from {lo} to {hi}
            while (l < h && key >= a[l]) { ++l; }
            if (l < h) { Sort.swap(a, l, h); }
        }

        // as every programmer knows that there l == h
        //  when run here, all arr[i<l]<=arr[l/h]<=arr[i>h] also exchange arr[lo] and arr[l/h]
        Sort.swap(a, lo, l);

        quickSort(a, lo, l - 1);
        quickSort(a, h + 1, hi);
    }

    /**
     * merge sort
     *
     * @param arr  int[]
     * @param low  include arr[low]
     * @param high include arr[high]
     */
    public void mergeSort(int[] arr, int low, int high) {
        // [low,high] should content low < high
        if (low >= high) { return; }

        // average of low and high
        int ave = low + ((high - low) >> 1);
        mergeSort(arr, low, ave);
        mergeSort(arr, ave + 1, high);

        int l = low, h = ave + 1;
        int[] tmp = new int[high - low + 1];
        int index = 0;

        // merge two sub sequence by increase
        while (l <= ave && h <= high) { tmp[index++] = (arr[l] <= arr[h]) ? arr[l++] : arr[h++]; }
        // merge the remaining one of two sequence
        while (l <= low) { tmp[index++] = arr[l++]; }
        while (h <= high) { tmp[index++] = arr[h++]; }

        // sort sequence[low,high] by copy temporary sequence directly
        for (int i = 0; i < tmp.length; ++i) {arr[low + i] = tmp[i];}
    }

    public static void merge(int[] a) {
        final int lo = 0, hi = a.length - 1;
        int mi = lo + ((hi - lo) >> 1);

        int l = lo, h = mi + 1;
        int[] aux = new int[a.length];
        for (int k = lo; k <= hi; ++k) {aux[k] = a[k];}

        for (int i = lo; i <= hi; ++i) {
            // 左半边用尽，取右半边元素
            if (l > mi) { a[i] = aux[h++]; }
            // 右半边用尽，取左半边元素
            else if (h > hi) { a[i] = aux[l++]; }
            // 左半边元素小于等于右半边元素
            else if (aux[l] <= aux[h]) { a[i] = aux[l++]; }
            // 右半边元素小于左半边元素
            else { a[i] = aux[h++]; }
        }
    }
}
