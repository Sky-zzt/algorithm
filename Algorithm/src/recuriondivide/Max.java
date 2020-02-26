package recuriondivide;



public class Max {

//求最大值
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 12, 65, 5, 89};
        int max = max(arr, 0, arr.length - 1);

        System.out.println(max);
    }

//二分分治递归求解最大值
    public static int max(int arr[], int low, int high) {
        if (low == high) {

            return arr[low];
        }
        int mid = (low + high) / 2;
        int lmax = max(arr, low, mid);
        int hmax = max(arr, mid + 1, high);

        return Math.max(lmax, hmax);
    }

}
