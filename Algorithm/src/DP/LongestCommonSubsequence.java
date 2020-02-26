package DP;

import java.util.zip.DeflaterOutputStream;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        int i = LCS("jiuzhang", "lijiang");
        //    System.out.println(i);

    }

    //去尾巴
    //设f[i][j]为A前i个字符A[0..i-1]和B前j个字符[0..j-1]的最长公共子串的长度
    public static int LCS(String s, String ss) {
        int m = s.length();
        int n = ss.length();
        char[] chars = s.toCharArray();
        char[] chars1 = ss.toCharArray();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 0;
                    continue;
                }                 //case 1      2
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (chars[i - 1] == chars1[j - 1]) {
                    //case 3
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);

                }
            }
        }
        for (int k = 0; k < f.length; k++) {
            for (int l = 0; l < f[0].length; l++) {
                System.out.print(f[k][l]+" ");
            }
            System.out.println(" ");
        }
        return f[m][n];
    }

    public static int  LCS1(String s, String ss) {
        int m = s.length();
        int n = ss.length();
        char[] chars = s.toCharArray();
        char[] chars1 = ss.toCharArray();
        int[][] f = new int[m + 1][n + 1];
        int[][] pai = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 0;
                    continue;
                }
                if (chars[i - 1] == chars1[j - 1]) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - 1] + 1);
                }
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                //打印
                if (f[i][j] == f[i - 1][j]) {
                    pai[i][j] = 1;
                }
                if (f[i][j] == f[i][j - 1]) {
                    pai[i][j] = 2;
                }
                if (f[i][j] == f[i - 1][j - 1]+1) {
                    pai[i][j] = 3;
                }
            }
        }
        char[] res = new char[f[m][n]];
        int p = f[m][n] - 1;
        int i = m;
        int j = n;
        /*
        行不通的   这样 不能保证 只走一个  用ifelse吧


         */
//        while (i > 0 && j > 0) {
//            if (pai[i][j] == 1) {
//                i--;
//            }
//            if (pai[i][j] == 2) {
//                j--;
//            }
//            if (pai[i][j] == 3) {
//                res[p--] = chars[i - 1];
//                i--;
//                j--;
//            }
//
//        }
//        System.out.println("================");
//        for (int k = 0; k < f[m][n]; k++) {
//            System.out.println(res[k]);
//        }
        for (int k = 0; k < f.length; k++) {
            for (int l = 0; l < f[0].length; l++) {
                System.out.print(f[k][l]+" ");
            }
            System.out.println(" ");
        }
        return f[m][n];
    }


}
