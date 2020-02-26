package Test;

public class TraverseTriangle {
    public static void main(String[] args) {

    }
    public int minimumTotal(int[][] triangle) {
        // write your code here
        int x = triangle.length;
        int y = triangle[0].length;
        Integer sum=0;

        return   traverse(0,0,sum,triangle);

    }
    public  int  traverse(int x,int y,int sum,int [][]A){

        int traverse = traverse(x + 1, y + 1, sum + A[x + 1][y + 1], A);
        int traverse1 = traverse(x + 1, y, sum + A[x][y], A);
        return Math.max(traverse,traverse1);
    }
}
