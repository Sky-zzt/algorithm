package Test;

import jdk.nashorn.internal.ir.GetSplitState;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class staticTest {

    public static void main(String[] args) {


    }

    /*
     给一个二维网格，每一个格子都有一个值，2 代表墙，1 代表僵尸，0 代表人类(数字 0, 1, 2)。
     僵尸每天可以将上下左右最接近的人类感染成僵尸，但不能穿墙。将所有人类感染为僵尸需要多久，如果不能感染所有人则返回 -1。
             */
    public static final int wall = 2;
    public static final int zombi = 2;
    public static final int pepole = 0;
    public static final int[] deltax = {1, 0, 0, -1};
    public static final int[] deltay = {0, 1, -1, 0};

    static class coordinate {
        int x;
        int y;

        public coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int minday(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Queue<coordinate> queue = new LinkedList<coordinate>();
        int people = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == pepole) {
                    people++;
                }
                if (grid[i][j] == zombi) {
                    queue.add(new coordinate(i, j));
                }
            }
        }
        int day = 0;
        if (people == 0) {
            return 0;
        }
        while (queue != null) {
            int size = queue.size();
            day++;
            for (int i = 0; i < size; i++) {
                coordinate poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = poll.x;
                    int y = poll.y;
                    coordinate coordinate = new coordinate(x + deltax[j], y + deltay[j]);
                    if (isbound(coordinate.x, coordinate.y, grid)) {
                        if (people == 0) {
                            return day;
                        }
                        if (grid[coordinate.x][coordinate.y] == pepole) {
                            grid[coordinate.x][coordinate.y] = zombi;
                            queue.add(coordinate);
                            people--;
                        }
                    }
                }
            }
        }
        return day;
    }

    public static boolean isbound(int x, int y, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (x >= m || x < 0) {
            return false;
        }
        if (y >= n || y < 0) {
            return false;
        }
        return true;
    }

    public static boolean isbound(int x, int y, boolean[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (x >= m || x < 0) {
            return false;
        }
        if (y >= n || y < 0) {
            return false;
        }
        return true;
    }


    private static void markByBFS(boolean grid[][], int x, int y) {
        Queue<coordinate> queue = new LinkedList<>();
        queue.add(new coordinate(x, y));
        grid[x][y]=false;
        while (queue != null) {
            coordinate poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                coordinate coordinate = new coordinate(poll.x + deltax[i],
                        poll.y + deltay[i]);

                if (isbound(coordinate.x, coordinate.y, grid)) {

                    if (grid[coordinate.x][coordinate.y]) {
                        queue.add(coordinate);
                        grid[coordinate.x][coordinate.y] = false;
                    }
                }
            }
        }
    }
}
