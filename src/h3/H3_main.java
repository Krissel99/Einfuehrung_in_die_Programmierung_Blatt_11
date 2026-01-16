package h3;

import java.util.Arrays;

public class H3_main {
    public static void main(String[] args) {
        int[] data   = {5, 8, 3, 1};
        int[] sorted = mergeSort(data);
        System.out.println(Arrays.toString(sorted));
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int   mid   = array.length/2;
        int[] left  = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        int[] sortedLeft  = mergeSort(left);
        int[] sortedRight = mergeSort(right);
        return merge(sortedLeft, sortedRight);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length+right.length];
        int   i      = 0;
        int   l      = 0;
        int   r      = 0;
        while (l < left.length && r < right.length) {
            result[i++] = (left[l] <= right[r]) ? left[l++] : right[r++];
        }
        while (l < left.length) {
            result[i++] = left[l++];
        }
        while (r < right.length) {
            result[i++] = right[r++];
        }
        return result;
    }
}