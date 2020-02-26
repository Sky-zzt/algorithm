package Test;

public class UniquePath {
    public static void main(String[] args) {
        System.out.println(uq(1,1));
    }

    public static int uq(int m, int n) {
        int f[][] = new int[m][n];
       // f[0][0] = 1;
        int i;
        int j=0;
        for ( i = 0; i <f.length; i++) {
            for ( j= 0; j <f[0].length ; j++) {
                if (i==0){
                    f[0][j]=1;
                }
                if (j==0){
                    f[i][0]=1;
                }
                if (i!=0&&j!=0){
                f[i][j]=f[i-1][j]+f[i][j-1];

            }
                System.out.print(f[i][j]);
                System.out.print(" ");
            }
            System.out.println("  ");
        }
        System.out.println();
        //out.println();
        return f[m-1][n-1];
    }
}
