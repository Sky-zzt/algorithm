package DP;

public class InterleavingString {
    public static void main(String[] args) {

    }
    //序列型动态规划的初始条件只需要考虑空空
    public static boolean isinterleave(String s,String s2,String s3){
        int m = s.length();
        int n = s2.length();
        char[] chars = s.toCharArray();
        char[] chars1 = s2.toCharArray();
        char[] chars2 = s3.toCharArray();
        boolean[][] f = new boolean[m + 1][n + 1];
        if (s3.length()!=m+n){
            return false;
        }
        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
                if (i==0&&j==0){
                    f[i][j]=true;
                    continue;
                }
                f[i][j]=false;
                if (i>0&&chars2[i+j-1]==chars[i-1]){
                    f[i][j]|=f[i-1][j];///  f[i][j]=f[i][j]|f[i-1][j]

                }
                if (j>0&&chars2[i+j-1]==chars1[j-1]){

                    f[i][j]|=f[i][j-1];
                }

            }
        }

return f[m][n];
    }
}
