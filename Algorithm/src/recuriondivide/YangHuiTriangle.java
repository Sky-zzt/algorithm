package recuriondivide;

public class YangHuiTriangle {

    public static int fun(int i, int j) {
        if (j == 1 || i == j) {
            return 1;
        } else {
            return fun(i - 1, j) + fun(i - 1, j - 1);
        }
    }

    public static void main(String[] args) {
        int length = 9;    // 打印的行数

        for (int i = 1; i <= length; i++) {

            // 打印空格
            for (int j = 1; j <= length - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.printf("%4d", fun(i, j));
            }
            System.out.println();
        }
    }


}
