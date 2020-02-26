package arrary;

public class MaxSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1,2,3,0,1}));
    }
    public static int maxsubarray(int nums[]){
        if (nums==null||nums.length==0){
            return 0;
        }
        int prefixsum=0;
        for (int i = 0; i < nums.length; i++) {
            prefixsum=prefixsum+nums[i];

        }

return 0;
    }
    /*
    给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。

Example
样例1:

输入：[−2,2,−3,4,−1,2,1,−5,3]
输出：6
解释：符合要求的子数组为[4,−1,2,1]，其最大和为 6
     */
    public static  int maxSubArray(int[] A) {
        if (A == null || A.length == 0){
            return 0;
        }
        //max记录全局最大值，sum记录前i个数的和，minSum之前前缀和的最小值  可以为0，但是买卖股票哪个就不行
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}
