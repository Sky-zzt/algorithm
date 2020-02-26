package binarysearch;

public class BinarySearchByCiculation {
    public static void main(String[] args) {
        System.out.println(BS(new int[]{1, 2, 3, 4, 5, 6}, 5));
    }

    public static int BS(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int end = nums.length - 1;
        int start = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;

    }

    public static int bsfpt(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;

        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }

        return -1;
    }


}
