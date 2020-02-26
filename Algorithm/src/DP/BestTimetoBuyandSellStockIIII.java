package DP;

import java.util.Arrays;

public class BestTimetoBuyandSellStockIIII {
    public int maxProfit(int[] prices) {
        // write your code here
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][5 + 1];

        for (int k = 1; k <= 5; k++) {
            dp[0][k] = Integer.MIN_VALUE;
        }
        dp[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            // 手中未持有股票
            for (int j = 1; j <= 5; j += 2) {
                // 前一天也未持有
                dp[i][j] = dp[i - 1][j]; //不能等于Integer.MIN_VALUE;  带入试试 {2, 1, 2, 0, 1}
                if (j > 1 && i > 1 && dp[i - 1][j - 1] != Integer.MIN_VALUE) {
                    //                            前一天持有，今天卖了获利。
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]));

                }
            }
            // 手中持有股票
            for (int j = 2; j <= 5; j += 2) {
                //前一天未持有，今天买进
                dp[i][j] = dp[i - 1][j - 1];
                if (i > 1 && dp[i - 1][j] != Integer.MIN_VALUE) {
                    //  前一天持有了，计算今天的利润
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
                if (i>1&&j>2&&dp[i-1][j-2]!=Integer.MIN_VALUE){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-2]+prices[i-1]-prices[i-2]);
                }

            }
        }
        int res = 0;
        for (int j = 1; j <= 5; j += 2) {
            res = Math.max(res, dp[n][j]);
        }
        return res;
    }
}

