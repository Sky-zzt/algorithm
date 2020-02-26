package Test;

public class paintHouse {
    public static void main(String[] args) {


    }
    public static int minCost(int[][] costs){

        int m = costs.length;
        int n = costs[0].length;
        int[][] f = new int[m+1][n+1];
        f[0][0]=f[0][1]=f[0][2]=0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j]=Math.min(Math.min(costs[i-1][0],costs[i-1][1]),costs[i-1][2]);

            }
        }
        return f[m][n];
    }
}
