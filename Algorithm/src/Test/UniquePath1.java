package Test;

public class UniquePath1 {
    public static void main(String[] args) {
        System.out.println(unique(new int[1][3]));

    }

    public static int unique(int matrix[][]) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f = new int[m][n];
        f[0][0] = 1;
        for (int i = 0; i <m; i++) {
            if (matrix[i][0]!=1){
                f[i][0]=1;
            }

        }
        for (int i = 0; i < n; i++) {
          if (matrix[0][i]!=1){
              f[0][i]=1;
          }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (f[i][j]!=1){
                    f[i][j]=f[i-1][j]+f[i][j-1];
                }

            }
        }

    return f[m-1][n-1];

    }
}
