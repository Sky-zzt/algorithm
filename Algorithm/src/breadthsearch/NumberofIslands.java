package breadthsearch;


/*
给一个 01 矩阵，求不同的岛屿的个数。

0 代表海，1 代表岛，如果两个 1 相邻，那么这两个 1 属于同一个岛。我们只考虑上下左右为相邻
 */
import java.util.LinkedList;
import java.util.Queue;

public class NumberofIslands {
    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
//陆地是true 海水是false
        public static int numIslands(boolean[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0){
                return 0;
            }
            int count=0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j]){  //陆地
                        markByBFS(grid,i,j);
                        count++;
                    }
                }
            }
            return count;
        }
        //这个的逻辑就是把相连的陆地全部变成海水false
        private static void markByBFS(boolean grid[][],int x,int y){
            int [] directionX={0,1,-1,0};
            int [] directionY={1,0,0,-1};
            Queue<Coordinate> queue = new LinkedList<>();
            queue.offer(new Coordinate(x,y));
            grid[x][y]=false;
            while (!queue.isEmpty()){
                Coordinate coor = queue.poll();
                for (int i = 0; i < 4; i++) {
                    Coordinate adj = new Coordinate(coor.x + directionX[i],
                            coor.y + directionY[i]);
                    if (!inBound(adj,grid)){
                        continue;
                    }
                    if (grid[adj.x][adj.y]){
                        grid[adj.x][adj.y]=false;
                        queue.offer(adj);
                    }


                }
            }




        }

        private static  boolean inBound(Coordinate coor, boolean[][] grid) {
         //   return coor.x>=0&&coor.y>=0&&coor.x<grid.length&&coor.y<grid[0].length;
            int n = grid.length;
            int m = grid[0].length;

            return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
        }


    }
}
