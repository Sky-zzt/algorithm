package Sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-1, 0, -11, 4, 8, 19, 2, 3, 5, 15};
        quicksort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {


            System.out.println(arr[i]);
        }

    }
/*

	 merge局部有序到整体有序  稳定排序  时间复杂度nlogn 空间复杂度 N
	quicksort 整体有序 在局部有序 不稳定
	时间复杂度  nlogn  实际使用O1,而真正（递归栈调用）空间复杂度 nlogn  因为每次递归调用需要 p数组来记录位置

 */

 // l + (int) (Math.random() * (r - l + 1)) 别忘了l
    public static void quicksort(int arr[], int l, int r) {
        if (l < r) {
            int[] p = partition(arr, l, r, arr[l + (int) (Math.random() * (r - l + 1))]); //随机选取一个数字进行分组
            quicksort(arr, l, p[0] - 1);
            quicksort(arr, p[1] + 1, r);
        }
    }
    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < p) {
                swap(arr, ++less, l++);
            } else if (arr[l] > p) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return new int[]{less + 1, more - 1}; //返回等于区域是哪个范围
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

