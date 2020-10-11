package arrary;

public class TopKLargestNumber {
    public static void main(String[] args) {
        int[] ints = {3,2,1};
         System.out.println(quickSelect(ints, 0, ints.length - 1, 2));
        // System.out.println(QuickSelect(3,ints));
    }
//第k大的数 或者 第k小的数  中位数  都可以 用这个  On时间复杂度  挺好
    public static int QuickSelect(int n, int nums[]) {
        if (nums == null) {
            return -1;
        }
        return quickSelect(nums, 0, nums.length - 1, nums.length - n); //这个第一大是真的第一大
    }
    public static int quickSelect(int[] arr, int l, int r, int K) { //这个第0大才是第一大 第n-1大才是第n大
        int[] p = partition(arr, l, r, arr[l + (int) (Math.random() * (r - l + 1))]);
        if (l + K <= p[0]) {
            return quickSelect(arr, l, p[0], K);
        } else if (l + K >= p[1]) {
            return quickSelect(arr, p[1], r, K - (p[1] - l));
        }
        //相等的情况
        return arr[p[0] + 1];
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
        return new int[]{less, more};
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
