package DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int longestIncreasingSubsequence(int[] nums) {


        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] f = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //f[j] = max{ 1, f[i] + 1| i < j and a[i] < a[j]}   1就是发【i】  但也别写成1啊
                    //他自己 长度1
                    f[i] = Math.max(f[j] + 1, f[i]);
                }
            }

        }
        Arrays.sort(f);
        return f[nums.length - 1];

    }
}