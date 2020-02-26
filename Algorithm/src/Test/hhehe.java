package Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.ArrayList;
import java.util.Stack;

public class hhehe {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {

    }
    public static int maxkill(char [][] grid){
        if (grid.length==0||grid==null||grid[0].length==0){
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] up = new int[m][n];
        int[][] dowm = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        //up
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='w'){
                    up[i][j]=0;
                }else if (grid[i][j]=='1'&&i-1>0){
                    up[i][j]=up[i-1][j]+1;
                }else if (i-1>0){
                    up[i][j]=up[i-1][j];
                }
            }
        }
        //dowm
        for (int i = m-1; i >=0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='w'){
                    dowm[i][j]=0;
                }else if (grid[i][j]=='1'&&i+1<m){
                    dowm[i][j]=dowm[i+1][j]+1;
                }else if (i-1>0){
                    dowm[i][j]=dowm[i+1][j];
                }
            }
        }
        //left
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]=='w'){
                    up[i][j]=0;
                }else if (grid[i][j]=='1'&&j-1>0){
                    up[i][j]=up[i][j-1]+1;
                }else if (j-1>0){
                    up[i][j]=up[i][j-1];
                }
            }
        }
        //right
        for (int i = 0; i < m; i++) {
            for (int j = n-1; j >=0; j--) {
                if (grid[i][j]=='w'){
                    up[i][j]=0;
                }else if (grid[i][j]=='1'&&j+1<n){
                    up[i][j]=up[i][j+1]+1;
                }else if (j+1<n){
                    up[i][j]=up[i][j+1];
                }
            }
        }
        int res=0;
        int sum=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum=up[i][j]+dowm[i][j]+left[i][j]+right[i][j];
                if (sum>res){
                    res=sum;
                }
            }
        }

return res;

    }

}
