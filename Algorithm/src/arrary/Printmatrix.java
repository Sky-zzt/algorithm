package arrary;

public class Printmatrix {

    /*
    转圈打印矩阵
【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
例如： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
15 16 打印结果为：1，2，3，4，8，12，16，15，14，13，9，
5，6，7，11， 10
【要求】 额外空间复杂度为O(1)。
     */
    public static void main(String[] args) {  //打印矩阵
        int[][] ints = new int[][]{{1, 2, 3},{4, 5, 6},{ 7, 8, 9}};
      printmatrix(ints);

    }

    public static void printmatrix(int matrix[][]){
        int lr=0;
        int lc=0;
        int rr=matrix.length-1;
        int rc=matrix[0].length-1;
        while (lr<=rr&&lc<=rc) {
            printedge(matrix,lr++,lc++,rr--,rc--);
        }

    }
    public static void printedge(int matrix[][],int lr,int lc,int rr,int rc){

        if(lr==rr){  //只有一行

            for (int i = lr; i <=rc ; i++) {   ///注意for的起始应该是lr而不是0；
                System.out.println(matrix[lr][i]+" ");

            }
        }else if (lc==rc){  //只有一列
            for (int i = lc; i <=rr ; i++) {
                System.out.println(matrix[i][lc]);
            }

        }
        else {
            int lc1=lc;
            int lr1=lr;
            while (lc1!=rc){
                System.out.println(matrix[lr][lc1]);
                lc1++;
            }
            while (lr1!=rr){

                System.out.println(matrix[lr1][rc]);
                lr1++;
            }
            while (lc1!=lc){
                System.out.println(matrix[rr][lc1]);
                lc1--;
            }
            while (lr1!=lr){
                System.out.println(matrix[lr1][lc]);
                lr1--;
            }

        }
    }
}
