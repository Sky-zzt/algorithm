package Test;

import com.sun.deploy.util.StringUtils;

import java.util.*;

public class jjjj {

    public static void main(String[] args) {
//        char[][] chars = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'a', 's', 'd'}};
//        System.out.println(haspath(chars,new char[]{'a','b','e'}));
        System.out.println(longestsubstring("arabcacfr"));

    }

    public static boolean haspath(char[][] matrix, char[] str) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] flag = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (helper(matrix, i, j, m, n, str, flag, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(char[][] matrix, int i, int j, int rows, int cols, char[] str, boolean[][] flag, int k) {

        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[i][j] != str[k] || flag[i][j]) {
            return false;
        }
        if (k == str.length - 1) {
            return true;
        }
        flag[i][j] = true;
        if (helper(matrix, i + 1, j, rows, cols, str, flag, k) ||
                helper(matrix, i - 1, j, rows, cols, str, flag, k) ||
                helper(matrix, i, j + 1, rows, cols, str, flag, k) ||
                helper(matrix, i, j - 1, rows, cols, str, flag, k)) {
            k++;
            return true;
        }
        flag[i][j] = false;
        return false;

    }

    {


    }

    public static int longestsubstring(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int m = chars.length;
        int[] f = new int[m];
        f[0] = 1;
        for (int i = 1; i < m; i++) {
         f[i] = 1;
            if (chars[i] != chars[i - 1]) {
                f[i] = Math.max(f[i], f[i - 1] + 1);
            }

        }
        Arrays.sort(f);
        return f[m-1];

    }
}
