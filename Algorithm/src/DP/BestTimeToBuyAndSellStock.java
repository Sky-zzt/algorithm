package DP;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(bestTime(new int[]{5,4,3,2,1}));
    }
    public static int  bestTime(int prices[]){
    int min=Integer.MAX_VALUE;
        int max=-100;
        for (int i = 0; i < prices.length; i++) {
           // int max = Math.max(min, prices[i]);
            for (int j = 0; j < i; j++) {
               min = Math.min(min, prices[j]);
            }
           max = Math.max(max, prices[i]-min);
        }
        if (max==-1){
            max=0;
        }
return max;
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;  //just remember the smallest price
        int profit = 0;
        for (int i : prices) {
            min = i < min ? i : min;
            profit = (i - min) > profit ? i - min : profit;
        }

        return profit;
    }

    public static int maxprofit(int prices[]){
        int length = prices.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            max=Math.max(max,prices[i]-min);
           // min=Math.min();

        }

        return 0;
    }
}
