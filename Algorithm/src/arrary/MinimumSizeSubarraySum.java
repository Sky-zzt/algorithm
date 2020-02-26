package arrary;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {

        System.out.println(minimumSize(new int[]{2, 3, 1, 2, 4, 3}, 7));
    }

    /*
    给定一个由 n 个正整数组成的数组和一个正整数 s ，请找出该数组中满足其和 ≥ s 的最小长度子数组。如果无解，则返回 -1。
     */
    public static int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum=0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {

                    ans = Math.min(ans, j - i + 1);
                    break; //z这个优化 很好
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
    //On
    public int minimumSize1(int[] nums, int s) {
        // write your code here
        int j = 0, i = 0;
        int sum =0;
        int ans = Integer.MAX_VALUE;
        for(i = 0; i < nums.length; i++) {
            while(j < nums.length && sum < s) { // 不用回退了 
                sum += nums[j];
                j ++;
            }
            if(sum >=s) {
                ans = Math.min(ans, j - i);
            }
            sum -= nums[i];
        }
        if(ans == Integer.MAX_VALUE)
            ans = -1;
        return ans;
    }
}
