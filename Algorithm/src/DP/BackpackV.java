package DP;

import java.util.Arrays;

public class BackpackV {
    public static void main(String[] args) {
//
//        System.out.println(backpack(new int[]{1, 2, 3, 3, 7}, 8));
//        System.out.println(backpack(new int[]{1,1,1,2}, 4));
        System.out.println(backpack(new int[]{1}, 0));
    }
/*
可以优化  和之前那盒就是把数组换成了int
和 backpack 可以深度对比一下
 */
    public static int backpack(int nums[], int target) {

        int n = nums.length;
        int[][] f = new int[n+1][target+1];
        f[0][0] = 1;
        for (int i = 1; i <= target; i++) {
            f[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                //System.out.println(j);
                f[i][j] = f[i - 1][j];
                if (j >= nums[i - 1]) {
                    f[i][j] = f[i-1][j] + f[i - 1][j - nums[i - 1]];
                }
            }


        }
        //System.out.println(Arrays.deepToString(f));
        return f[n][target];
    }
}
