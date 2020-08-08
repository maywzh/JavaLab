import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 9, 8, 6, 7, 5, 3, 4, 1, 2 };
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (temp < arr[right] && left < right) {
                right--;
            }
            if (left < right) {
                arr[left] = arr[right];
                left++;
            }
            while (temp > arr[left] && left < right) {
                left++;
            }
            if (left < right) {
                arr[right] = arr[left];
                right--;
            }
        }
        arr[left] = temp;
        return left;
    }

    private static void sort(int[] arr, int left, int right) {
        if (arr == null || left >= right || arr.length <= 1) {
            return;
        }
        int mid = partition(arr, left, right);
        sort(arr, left, mid - 1);
        sort(arr, mid + 1, right);
    }

}
