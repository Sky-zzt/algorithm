package breadthsearch;

import java.util.LinkedList;
import java.util.Queue;

/*
给一个二维网格，每一个格子都有一个值，2 代表墙，1 代表僵尸，0 代表人类(数字 0, 1, 2)。
僵尸每天可以将上下左右最接近的人类感染成僵尸，但不能穿墙。将所有人类感染为僵尸需要多久，如果不能感染所有人则返回 -1。
 */
public class Zonmbi {

    public static class coordinate {
        private int x;
        private int y;

        public coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class solution {
        private static int PEOPLE = 0;
        public static int ZOMBIE = 1;
        public static int WALL = 2;
        public static int deltaX[] = {1, 0, 0, -1};
        public static int deltaY[] = {0, -1, 1, 0};

        public static int zombie(int grid[][]) {
            if (grid == null || grid[0].length == 0 || grid.length == 0) {
                return 0;
            }
            int people = 0;
            LinkedList<coordinate> queue = new LinkedList<>();
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == PEOPLE) {
                        people++;
                    } else if (grid[i][j] == ZOMBIE) {
                        queue.offer(new coordinate(i, j));
                    }
                }
            }
            if (people == 0) {
                return 0;
            }
            int days = 0;
            while (queue != null) {

                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    coordinate poll = queue.poll();
                    for (int j = 0; j < 4; j++) {
                        coordinate adj = new coordinate(poll.x + deltaX[j], poll.y + deltaY[j]);
                        if (grid[adj.x][adj.y] == PEOPLE) {
                            grid[adj.x][adj.y] = ZOMBIE;
                            people--;
                            queue.offer(adj);
                        }
                        if (people == 0){
                            return days;
                        }
                        if (grid[adj.x][adj.y] == WALL){
                            continue;
                        }

                    }


                }

            }

return -1; ///这是-1  就是不能全部感染
        }
    }


    class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Solution {
        public int PEOPLE = 0;
        public int ZOMBIE = 1;
        public int WALL = 2;

        public int[] deltaX = {1, 0, 0, -1};
        public int[] deltaY = {0, 1, -1, 0};

        /**
         * @param grid a 2D integer grid
         * @return an integer
         */
        public int zombie(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }

            int n = grid.length;
            int m = grid[0].length;

            // initialize the queue & count people
            int people = 0;
            Queue<Coordinate> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == PEOPLE) {
                        people++;
                    } else if (grid[i][j] == ZOMBIE) {
                        queue.offer(new Coordinate(i, j));
                    }
                }
            }

            // corner case
            if (people == 0) {
                return 0;
            }

            // bfs
            int days = 0;
            while (!queue.isEmpty()) {
                days++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Coordinate zb = queue.poll();
                    for (int direction = 0; direction < 4; direction++) {
                        Coordinate adj = new Coordinate(
                                zb.x + deltaX[direction],
                                zb.y + deltaY[direction]
                        );

                        if (!isPeople(adj, grid)) {
                            continue;
                        }

                        grid[adj.x][adj.y] = ZOMBIE;
                        people--;
                        if (people == 0) {
                            return days;
                        }
                        queue.offer(adj);
                    }
                }
            }

            return -1;
        }

        private boolean isPeople(Coordinate coor, int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            if (coor.x < 0 || coor.x >= n) {
                return false;
            }
            if (coor.y < 0 || coor.y >= m) {
                return false;
            }
            return (grid[coor.x][coor.y] == PEOPLE);
        }
    }
}
