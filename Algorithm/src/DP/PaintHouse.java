package DP;

public class PaintHouse {
    public static void main(String[] args) {
        System.out.println(painthouse(new int [][]{{14,2,11},{11,14,5},{14,3,10}}));

    }
//序列型就只需要多考虑为0 这种情况 所以 发return【m】【n】
    public static int painthouse(int[][] cost) {
        int m = cost.length;
        int[][] f = new int[m + 1][3];
        if (m == 0) {
            return 0;
        }
        f[0][0] = f[0][1] = f[0][2] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < 3; j++) { //j is the color of house i-1
                f[i][j] = Integer.MAX_VALUE;//别忘了
                for (int k = 0; k < 3; k++) {  //k is the color of house i-2
                    if (j==k){
                        continue;
                    }
                    if (f[i-1][k]+cost[i-1][j]<f[i][j]){  //思考cost为啥不是cost【i】
                        f[i][j]  = f[i-1][k]+cost[i-1][j];
                    }

                }

            }
        }
       return Math.min(Math.min(f[m][0],f[m][1]),f[m][2]);

    }
}
