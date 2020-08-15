import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 9, 8, 6, 7, 5, 3, 4, 1, 2 };
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] merged) {
        int i = left, j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                merged[k++] = arr[i++];
            } else {
                merged[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            merged[k++] = arr[i++];
        }
        while (j <= right) {
            merged[k++] = arr[j++];
        }
        for (k = 0; k < right - left + 1; k++) {
            arr[k + left] = merged[k];
        }
    }
}