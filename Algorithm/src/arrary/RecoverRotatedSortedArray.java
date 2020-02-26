package arrary;

public class RecoverRotatedSortedArray {

    // 给定一个旋转排序数组，在原地恢复其排序。Example
    //[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
    //前一部分reverse 后一部分reverse 整体reverse

    public static void reverseArray(int arr[], int start, int end) {
        if (start < end) {
            swap(arr, start, end);
            reverseArray(arr, start + 1, end - 1);

        }
    }

    public static void RecoverRotatedSortedArray(int arr[]) {

        //弄一个全局变量记录在数组的位置
        int i = 0;
        //第一步
        for (i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                reverseArray(arr, 0, i);
                break;
            }
        }
        //第二步
        reverseArray(arr, i + 1, arr.length - 1);
        //第三步
        reverseArray(arr, 0, arr.length - 1);

    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6,};

//        reverseArray(arr,3,arr.length-1);
//        for (int i : arr) {
//            System.out.println(i);
//        }
//        System.out.println("---------------------");
        RecoverRotatedSortedArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
