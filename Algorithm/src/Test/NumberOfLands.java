package Test;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfLands {
    class coordinate {
        int x;
        int y;

        public coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int numlands(boolean[][] grid) {
            if (grid.length == 0 || grid[0].length == 0 || grid == null) {
                return 0;
            }
            int count=0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j]){
                        markByBfs(grid,i,j);
                        count++;
                    }
                }
            }
            return count;
        }

        public void markByBfs(boolean[][] grid, int x, int y) {
            int xdirection[] = {0, 1, -1, 0};
            int ydirection[] = {1, 0, 0, -1};
            Queue<coordinate> queue = new LinkedList<>();
            grid[x][y] = false;
            queue.add(new coordinate(x, y));
            while (!queue .isEmpty()) {
              //  queue.isEmpty()
                coordinate coor = queue.poll();
                for (int i = 0; i < 4; i++) {
                    coordinate adj = new coordinate(coor.x + xdirection[i],
                            coor.y + ydirection[i]);
                    if (!inBound(adj, grid)) {
                        continue;
                    }
                    if (grid[adj.x][adj.y] == true) {
                        queue.add(adj);
                    }
                    if (grid[adj.x][adj.y] = true) {
                        grid[adj.x][adj.y] = false;
                    }
                }
            }
        }

        private boolean inBound(coordinate coor, boolean[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
        }
    }
}
