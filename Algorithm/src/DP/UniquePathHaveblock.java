package DP;

public class UniquePathHaveblock {
    public static void main(String[] args) {
        System.out.println(uniquepathnum(new int[][]{{1, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}}));
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


