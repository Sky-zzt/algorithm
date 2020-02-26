package Test;

import jdk.nashorn.internal.ir.IfNode;

import java.awt.*;
import java.util.*;
import java.util.List;

public class test1 {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {


    }

    public static int traverse(int[][] grid) {
        if (grid==null||grid.length==0||grid[0].length==0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0]=0;


        for (int i = 1; i < m; i++) {
          //  f[i][0]+=grid[i][0];
            f[i][0]=f[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < n; i++) {
          //  f[0][i]+=grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j]=Math.min(f[i-1][j],f[i][j-1])+grid[i][j];
            }
        }
return f[m-1][n-1];

    }


}
