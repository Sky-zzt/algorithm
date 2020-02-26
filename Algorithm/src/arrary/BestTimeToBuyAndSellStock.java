package arrary;

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
    /*
    假设有一个数组，它的第i个元素是一支给定的股票在第i天的价格。
    如果你最多只允许完成一次交易(例如,一次买卖股票),设计一个算法来找出最大利润。

     */
    //max记录全局最大值，sum记录前i个数的和，minSum之前前缀和的最小值  可以为0，但是买卖股票哪个就不行
    //因为 0如果是最终最小值 不一定在 数组中出现  随意min 要在数组中随便去一个做初始值（只能取0位置的，因为 此时可以保证min有一个0）
    //这样的话就会保证不买的情况
    public static int maxprofit(int prices[]){
        int length = prices.length;
        int min=prices[0];
        int max=Integer.MIN_VALUE;//也可以=0
        for (int i = 0; i < length; i++) {
            max=Math.max(max,prices[i]-min);
            min=Math.min(min,prices[i]);
        }
        return max;
    }
}
