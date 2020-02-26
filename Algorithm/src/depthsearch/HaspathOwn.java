package depthsearch;

public class HaspathOwn {

    public static void main(String[] args) {
        char[][] chars = new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'a', 's', 'd'}};
        System.out.println(haspath(chars,new char[]{'a','b','e'}));

        if (false||0==1){
            System.out.println("999");
        }
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
        flag[i][j]=true;
        if (helper(matrix, i + 1, j, rows, cols, str, flag, k + 1) ||
                helper(matrix, i - 1, j, rows, cols, str, flag, k + 1) ||
                helper(matrix, i, j + 1, rows, cols, str, flag, k + 1) ||
                helper(matrix, i, j - 1, rows, cols, str, flag, k + 1)) {
            return true;
        }
        flag[i][j]=false;
        return false;

    }
}
