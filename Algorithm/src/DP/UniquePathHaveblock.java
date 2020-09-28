package DP;

public class UniquePathHaveblock {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{ {0, 0}, {1, 0}, {0, 0} }));
    }



    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //获取网格的长宽
        int n = obstacleGrid.length,m = obstacleGrid[0].length;
        if (n == 0 || m == 0) {
            return 0;
        }
        int[][] dp = new int[n][m];
        //对于左边界，第一个障碍物或边界前的所有边界点皆可到达
        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++){
                if (i==0 && j==0) {
                    continue;
                }
                //若遇到障碍物，则跳过
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                //对于上边界，第一个障碍物或边界左边的所有边界点皆可到达
                if (i == 0) {
                    dp[i][j] = dp[i][j-1];
                    continue;
                }
                //对于左边界，第一个障碍物或边界前的所有边界点皆可到达
                if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                //到达当前点的路径数等于能到达此点上面的点和左边点的路径数之和
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }

    public static int uniquepathnum(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (a[i][j] == 1) {
                    f[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        f[i][j] = 1;
                    } else if (i == 0 && j > 0) {//第一行和第一列  但是j要大于0  所以可以提前计算出j
                        f[i][j] = f[i][j - 1];//
                    } else if (j == 0 && i > 0) {
                        f[i][j] = f[i - 1][j];//
                    } else {
                        f[i][j] = f[i - 1][j] + f[i][j - 1];
                    }

                }
            }

        }
        return f[m - 1][n - 1];
    }
}


