package day01;

public class Hanotower {
    public static void main(String[] args) {
        hano(4, 'A', 'B', 'C');


    }

    public static void hano(int s, char a, char b, char c) {
        if (s == 1) {
            System.out.println("第yi个盘子从" + a + "移动到" + c);
        } else {
            hano(s - 1, a, c, b);
            System.out.println("第"+s+"个盘子从"+a+"移动到"+c);
            hano(s-1,b,a,c);

        }


    }

}
