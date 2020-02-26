package DP;

public class BackpackV {
    public static void main(String[] args) {

        System.out.println(backpack(new int[]{1, 2, 3, 3, 7}, 10));
    }
/*
可以优化  和之前那盒就是把数组换成了int
和 backpack 可以深度对比一下
 */
    public static int backpack(int arr[], int K) {

        int n = arr.length;
        int[][] f = new int[n+1][K+1];
        f[0][0] = 1;
        for (int i = 1; i <= K; i++) {
            f[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= K; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= arr[i - 1]) {
                    f[i][j] = f[i][j] + f[i - 1][j - arr[i - 1]];
                }
            }


        }
        return f[n][K];
    }
}
