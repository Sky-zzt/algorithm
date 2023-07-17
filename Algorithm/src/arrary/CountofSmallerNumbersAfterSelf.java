package arrary;

public class CountofSmallerNumbersAfterSelf {

    public static class MinimumSizeSubarraySum {
        public static void main(String[] args) {

            minimumSize(new int[]{2,3,1,2,4,3},7);
        }

        public static void minimumSize(int[] nums, int s) {
            // write your code here
            int sum = 0;
            int min = Integer.MAX_VALUE;
            int count = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j <= i; j++) {

                    for (int k = j; k <= i; k++) {
                        sum += nums[k];
                        if (sum >= s) {
                            count = 0;
                            count = i - j + 1; //
                        }
                        min = Math.min(min, count);
                    }
                    sum=0;
                }
                sum=0;

            }
        }
    }
}
