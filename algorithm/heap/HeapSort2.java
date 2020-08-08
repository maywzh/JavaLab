import java.util.Arrays;

public class HeapSort2 {
    public static void main(String[] args) {

        int[] arr = new int[] { 0, 2, 4, 1, 5 };
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 堆排序方法
    public static void heapSort(int arr[]) {
        // 进行第一次调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }

        for (int j = arr.length - 1; j > 0; j--) {
            // 进行交换
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            // 调整长度为j的那些
            // 这里为什么填0呢
            // 因为我们第一次调整的时候从左到右，从下到上调整的；
            // 交换时只是变动了堆顶元素和末尾元素
            // 末尾元素我们不用去管，因为已经是之前长度最大的了
            // 只需要把当前堆顶元素找到合适的位置即可
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * author:微信公众号:code随笔
     * 
     * @param arr    待排序的数组
     * @param i      表示等待调整的哪个非叶子节点的索引
     * @param length 待调整长度
     */
    public static void adjustHeap(int arr[], int i, int length) {
        // 非叶子节点的值
        int notLeafNodeVal = arr[i];
        // k的初始值为当前非叶子节点的左孩子节点的索引
        // k = 2 * k + 1表示再往左子节点找
        for (int k = i * 2 + 1; k < length; k = 2 * k + 1) {
            // 如果k + 1还在待调整的长度内，且右子树的值大于等于左子树的值
            // 将k++，此时为当前节点的右孩子节点的索引
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            // 如果孩子节点大于当前非叶子节点
            if (arr[k] > notLeafNodeVal) {
                arr[i] = arr[k];// 将当前节点赋值为孩子节点的值
                i = k;// 将i赋值为孩子节点的值，再看其孩子节点是否有比它大的
            } else {
                break;// 能够break的保证是，我们是从左至右，从下到上进行调整的
                // 只要上面的不大于，下面的必不大于
            }
        }
        // 循环结束后，将i索引处的节点赋值为之前存的那个非叶子节点的值
        arr[i] = notLeafNodeVal;
    }
}