package DP;

public class Backpack {
    public static void main(String[] args) {

    }

    public static int backpack(int arr[], int K) {
        int n = arr.length;
        boolean[][] f = new boolean[n+1][K+1];
        f[0][0] = true;
        for (int i = 1; i <=K ; i++) {
            f[0][i]=false;
        }
        /*
需要知道N个物品是否能拼出重量W (W =0, 1, …, M)
• 最后一步：最后一个物品（重量A N-1 ）是否进入背包
0 1 2 … M-1 M
情况一：如果前N-1个物品能拼出W，当然前N个物品也能拼出W
情况二：如果前N-1个物品能拼出W- A N-1  ，再加上最后的物品A N-1  ，拼出W
 不能 f[i][j]=f[i-1][j]||f[i-1][j-arr[i-1]];  因为不一定能进来if 所以提前
         */
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <=K ; j++) {
                f[i][j]=f[i-1][j];
                if (j>=arr[i-1]){
                    f[i][j]=f[i][j]||f[i-1][j-arr[i-1]];  //不能
                }
            }
        }


        for (int i = K; i>=0 ; --i) {
            if (f[n][i]){
                return i;
            }
        }
        return 0;
    }
}
