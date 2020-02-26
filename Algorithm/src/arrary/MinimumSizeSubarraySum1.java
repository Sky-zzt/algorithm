package arrary;

public class MinimumSizeSubarraySum1 {
//最简单的暴力方法 但是 两个sum=0（没有的话每次sum都会累加 ）以及 count = i - j + 1;要注意
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums.length == 0) {
            return -1;
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {

                for (int k = j; k <= i; k++) {
                    sum += nums[k];
                    if (sum >= s) {
                        count = 0;
                        count = i - j + 1;//
                    }
                    min = Math.min(min, count);
                }
                sum = 0;  //
            }
            sum = 0;//
        }
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        return min;
    }
}
