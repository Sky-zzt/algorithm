package binarysearch;

public class BinarySearchFirstPositionofTarget {
/*
给定一个排序的整数数组（升序）和一个要查找的整数target，
用O(logn)的时间查找到target第一次出现的下标（从0开始），如果target不存在于数组中，返回-1
psvm
 */

    public static void main(String[] args) {
        System.out.println(BS1(new int[]{2,2,2,2,3,4,5,6,7,8},2));

    }
    public static int BS1(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int end = nums.length - 1;
        int start = 0;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                //  return mid;  不行
                //核心在这里  最后一个位置的话就 start=mid；  二分无论对返回位置有没有要球 都可以这么写
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[start] == target) {
            return start;
        }

        return -1;

    }
}
