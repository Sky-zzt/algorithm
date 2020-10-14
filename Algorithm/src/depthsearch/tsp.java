package depthsearch;

/*
有n个城市，给出邻接矩阵arr代表任意两个城市的距离。arr[i][j]代表从城市i到城市j的距离。Alice在周末制定了一个游玩计划，她从所在的0号城市开始，游玩其他的1~n-1个城市，
最后回到0号。Alice想知道她能完成游玩计划需要行走的最小距离。返回这个最小距离。除了城市0之外每个城市只能经过一次。

n<=10 arr[i][j]<=10000
样例
例1:

输入:[[0,1,2],[1,0,2],[2,1,0]]
输出:4
解释:
[[0,1,2],
 [1,0,2],
 [2,1,0]]
有两种可能的方案。
第一种，城市0->城市1->城市2->城市0，cost=5。
第二种，城市0->城市2->城市1->城市0，cost=4。
返回4
例2:

输入:[[0,10000,2],[5,0,10000],[10000,4,0]]
输出:11
 */
public class tsp {
    static int res;

    //画一下 dfs 深度搜索的图  你会理解更多
    public int travelPlanII(int[][] arr) {
        // Write your code here.
        res = Integer.MAX_VALUE;
        int n = arr.length;
        boolean[] visited = new boolean[n];
        DFS(0, 0, 0, n, arr, visited);
        return res;
    }

    public static void DFS(int step, int curDis, int curCity, int n, int[][] arr, boolean[] visited) {
        if (step == n) {
            if (curCity == 0) {
                res = Math.min(res, curDis);
                return;
            }
        }
        if (curDis >= res)
            return;
        for (int i = 0; i < n; i++) {
            if (curCity == i)  //todo 这个if可以让他返回起点（但是 你不debug 还真看不出来）   一个更好理解的做法是，不让他返回 当step==n是 加上起点到终点的距离不就行了 https://www.jiuzhang.com/problem/travel-plan/
                continue;
            if (!visited[i]) {
                visited[i] = true;
                DFS(step + 1, curDis + arr[curCity][i], i, n, arr, visited);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        //[[0,1,2],
        // [1,0,2],
        // [2,1,0]]
        //有两种可能的方案。
        //第一种，城市0->城市1->城市2->城市0，cost=5。
        //第二种，城市0->城市2->城市1->城市0，cost=4。
        int[][] ints = {{0, 1, 2}, {1, 0, 2}, {2, 1, 0}};
        System.out.println(new tsp().travelPlanII(ints));

    }
}