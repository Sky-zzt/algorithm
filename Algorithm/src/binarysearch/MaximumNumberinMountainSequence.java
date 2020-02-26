package binarysearch;

public class MaximumNumberinMountainSequence {

    public static void main(String[] args) {
/*
        给 n 个整数的山脉数组，即先增后减的序列，找到山顶（最大值）
二分 一半一半的扔掉
 */

//和 Find Peak Element 是一样的
    }

    public static int maxnum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid]>nums[mid+1]){  // 这个条件是点睛之笔  判断  判断是在升序区间还是降序 不一定非要 nums[mid]>nums[end/start]
                end=mid;
            }else {
                start=mid;
            }
        }
        return Math.max(nums[start],nums[end]);

    }
}
