package DP;

public class BestTimetoBuyandSellStockIII {

    public static void main(String[] args) {

        int besttime = besttime(2, new int[]{2, 1, 2, 0, 1});
        System.out.println(besttime);
    }

    public static int besttime(int K, int[] P) {
        int n = P.length;
        if (n == 0) {
            return 0;
        }
        int i, j, k;
        if (K > n / 2) {
            // best time to buy and sell stock ii
            int tmp = 0;
            for (i = 0; i < n - 1; ++i) {
                tmp += Math.max(0, P[i + 1] - P[i]);
            }
            return tmp;
        }
        int[][] f = new int[n + 1][2 * K + 1 + 1];
        for (k = 1; k <= 2 * K + 1; ++k) {
            f[0][k] = Integer.MIN_VALUE; // impossible
        }
        f[0][1] = 0;
        for (i = 1; i <= n; ++i) {
            // 阶段1, 3, .. 2 * K + 1: f[i][j] = max{f[i-1][j], f[i-1][j-1] + Pi-1 – Pi-2}
            for (j = 1; j <= 2 * K + 1; j += 2) {
                f[i][j] = f[i - 1][j];//
                if (j > 1 && i > 1 && f[i - 1][j - 1] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + P[i - 1] - P[i - 2]);
                }
            }
            // 阶段2, 4.., 2K: f[i][j] = max{f[i-1][j] + Pi-1 – Pi-2, f[i-1][j-1]}
            for (j = 2; j <= 2 * K + 1; j += 2) {
                f[i][j] = f[i - 1][j - 1];
                if (i > 1 && f[i - 1][j] != Integer.MIN_VALUE) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j] + P[i - 1] - P[i - 2]);
                }
            }
        }
        int res = 0;
        for (j = 1; j <= 2 * K + 1; j += 2) {
            res = Math.max(res, f[n][j]);
        }
        return res;
    }
}
