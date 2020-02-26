package Test;

import javax.xml.stream.FactoryConfigurationError;

public class hhhhhh {

    public static void main(String[] args) {

    }

    public static int painthouse2(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int m = costs.length;
        int n = costs[0].length;
        int[][] f = new int[m + 1][n];
        for (int i = 0; i < n; i++) {
            f[0][i] = 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }
                    if (f[i][j]>f[i-1][j]+costs[i-1][k]){
                        f[i][j]=f[i-1][j]+costs[i-1][k];
                    }
                }
            }
        }
        int min=0;
        min=f[m][0];
        for (int i = 0; i <n-1 ; i++) {

            min = Math.min(min, f[m][i + 1]);
        }
        return min;

    }
    public static int minCut(String s){
        if (s==null||s.length()==0){
            return 0;
        }
        boolean[][] isPalindrome = getIsPalindrome(s);

        int m = s.length();
        int[] f = new int[m + 1];
        f[0]=0;

        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < i; j++) {
                if (j<i-1&&isPalindrome[j][i-1]){

                }
            }
        }
return 0;
    }

    private static boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                        = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }

        return isPalindrome;
    }


    public static boolean[][] isp(String s ){
        char[] chars = s.toCharArray();
        int m = chars.length;
        boolean[][] booleans = new boolean[m][m];
        for (int i = 0; i <m; i++) {

            int t,j;
            t=j=i;
            //odd
            while (i>=0&&j<m&&chars[t]==chars[j]){
                if (chars[i]==chars[j]){
                    booleans[i][j]=true;
                    i--;
                    j++;
                }
            }
            //even
            t=i;
            j=i+1;
            while (i>=0&&j<m){
                if (chars[i]==chars[j]);
            }

        }
return null;
    }
    public static int maxProfit(int[] prices) {
        // write your code here
        if (prices.length==0||prices==null){
            return 0;
        }
        int m = prices.length;
        int[][] f = new int[m + 1][6];
        for (int i = 1; i <=5; i++) {
            f[0][i]=Integer.MIN_VALUE;
        }
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=5 ; j+=2) {
                f[i][j]=Integer.MIN_VALUE;
                if (i>1&&j>1&&f[i-1][j-1]!=Integer.MAX_VALUE){

                }
                f[i][j] =Math.max(f[i][j],Math.max(f[i-1][j],f[i-1][j-1]+prices[i-1]-prices[i-2]));

            }
            for (int j = 2; j <=5 ; j+=2) {

            }
        }


return 0;

    }


}
