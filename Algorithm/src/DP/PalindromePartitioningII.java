package DP;

public class PalindromePartitioningII {

    public static void main(String[] args) {
        System.out.println(minCut("abssbaaaa"));
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
    private static boolean[][] CalcPalin(String s, int n) {
        boolean[][] isPalin = new boolean[n][n];
        int i, j, p;
        for (i = 0; i < n; ++i) {
            for (j = 0; j < n; ++j) {
                isPalin[i][j] = false;
            }
        }

        for (p = 0; p < n; ++p) {
            i = j = p;
            while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                isPalin[i][j] = true;
                --i;
                ++j;
            }
        }

        for (p = 0; p < n-1; ++p) {
            i = p;
            j = p + 1;
            while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                isPalin[i][j] = true;
                --i;
                ++j;
            }
        }

        return isPalin;
    }
    public static int minCut(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n+1];
        //int[] pi = new int[n + 1];
        int i, j, p;
        boolean[][] isPalin = CalcPalin(s, n);
        f[0] = 0;
        for (i=1; i<=n; ++i) {
            f[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; ++j) {
                if (isPalin[j][i-1] && f[j] != Integer.MAX_VALUE && f[j] + 1 < f[i]) {
                    f[i] = f[j] + 1;
                    //pi[i] = j;
                }
            }
        }

        // print solution
        /*i = n;
        while (i != 0) {
            // pi[i]~i-1
            for (j = pi[i]; j < i; ++j) {
                System.out.print(s[j]);
            }

            System.out.println("");
            i = pi[i];
        }*/

        return f[n] - 1;
    }
}
