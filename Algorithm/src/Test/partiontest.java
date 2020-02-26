package Test;

public class partiontest {
    public static int[] partion(int[] arr, int target) {
        int begin = 0;
        int end = arr.length - 1;
        while (begin < end) {
            while (begin<end&&arr[begin]<target){
                begin++;
            }
            while (begin<end&&arr[end]>target){
                end--;
            }
            if (begin<=end){
                swap(arr,begin,end);
            }
        }
        return new int[]{begin,end};
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
