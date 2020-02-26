package DP;

public class PalindromePartitioningII {

    public static void main(String[] args) {
        System.out.println(mincut("abssbaaaa"));
    }

    public static int mincut(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        boolean[][] ispain = new boolean[n][n];
        int i, j, t;
        for (i = 0; i < n; i++) {
            for (j = i; j < n; j++) {  //JUST init
                ispain[i][j] = false;
            }
        }
        //generate palindrom
        for (t = 0; t < n; t++) {
            //odd len
            i = j = t;
            while (i >= 0 && j < n && chars[i] == chars[j]) {
                ispain[i][j] = true;
                i--;
                j++;
            }
            //even len
            i = t;
            j = t + 1;
            while (i >= 0 && j < n && chars[i] == chars[j]) {

                ispain[i][j] = true;
                i--;
                j++;
            }
        }
        int[] f = new int[n + 1];
        f[0] = 0;
        for (i = 1; i <= n; i++) {
            f[i] =Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (ispain[j][i - 1]) {
                    f[i] = Math.min(f[j] + 1, f[i]);
                }
            }
        }
        return f[n] - 1;
    }
}
