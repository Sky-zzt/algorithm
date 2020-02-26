package DP;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(lps("bbbzbabab"));
    }
    public static int lps(String ss){
        if (ss==null||ss.length()==0){
            return 0;
        }
        char[] s = ss.toCharArray();
        int n = s.length;
        int[][] f = new int[n][n];
        int[][] pai = new int[n][n];

       // len=1
        for (int i = 0; i <n ; i++) {
            f[i][i]=1;
        //len=2      主要是因为只有大于等于2  才可以  保证  i+1，j-1  有意义（29行）
        }
        for (int j = 0; j < n - 1; j++) {
            f[j][j+1]=(s[j]==s[j+1]?2:1);
        }
        //len  from 3  to n
        int k;
        for (int len = 3; len <=n ; len++) {
            for (int i = 0; i <=n-len ; i++) {
                k=i+len-1;
                f[i][k]=Math.max(f[i][k-1],f[i+1][k]);
                if (s[i]==s[k]){
                    f[i][k]=Math.max(f[i][k],f[i+1][k-1]+2);

                }
                if (f[i][k]==f[i][k-1]){
                    pai[i][k]=1;
                }
                if (f[i][k]==f[i+1][k]){
                    pai[i][k]=2;
                }
                if (f[i][k]==f[i+1][k-1]){
                    pai[i][k]=3;
                }
            }
        }


return f[0][n-1];
    }
}
