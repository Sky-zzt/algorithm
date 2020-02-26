package binarysearch;

public class BinarySearch {
    public static void main(String[] args) {  //二分查找ta=6；
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(BS(nums, 5, 0, 7));
    }

    public static int BS(int nums[], int target, int start, int end) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                return BS(nums, target, mid + 1, end);
            } else if (nums[mid] > target) {
                return BS(nums, target, start, mid - 1);
            } else {
                return mid;
            }
        }

        return -1;
        //  return -1;
    }
}

