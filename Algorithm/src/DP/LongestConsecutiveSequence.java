package DP;

public class LongestConsecutiveSequence {
    /*
    给定一个未排序的整数数组，找出最长连续序列的长度
    输入 : [100, 4, 200, 1, 3, 2]
输出 : 4
解释 : 这个最长的连续序列是 [1, 2, 3, 4]. 返回所求长度 4
     */
    public LongestConsecutiveSequence(int aa){
        this.a=aa;
    }
    int a=10;
private static  class f{
 LongestConsecutiveSequence  aa=new LongestConsecutiveSequence(10);


    }
    public static void main(String[] args) {

        int x=0;
        int i=0;
        while (i<10){
            i++;
            x=x++;
        }
        System.out.println(x);
    }
}
