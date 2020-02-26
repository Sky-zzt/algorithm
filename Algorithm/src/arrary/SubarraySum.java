package arrary;

import java.util.ArrayList;
import java.util.HashMap;

public class SubarraySum {
    public static void main(String[] args) {

    }
//给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组的起始位置和结束位置
    //和为0 意味着有两个的前缀和相等
    //返回任意一段和为0的区间即可。
    public static  ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        int len = nums.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                ans.add(map.get(sum) + 1);
                ans.add(i);
                return ans;
            }
            map.put(sum, i);
        }
        return ans;
    }
    public static  ArrayList<Integer> subarraySum1(int[] nums){
        int prefixSum=0;
        int minSum=0;
        int max=Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);//这个必须有
        for (int i = 0; i < nums.length; i++) {
            prefixSum+=nums[i];

            if (!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }else {
            //    return map.get(prefixSum);
            }
            //max=Math.max(max,prefixSum-minSum);
            //minSum=Math.min(minSum,prefixSum);  用不到
        }
        return list;
    }
    public static  ArrayList<Integer> subarraySum2(int[] nums) {
        // write your code here
        int len = nums.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int prefixsum=0;
        for (int i = 0; i < len; i++) {
            prefixsum+=nums[i];
            if (map.containsKey(prefixsum)){
                ans.add(map.get(prefixsum)+1);
                ans.add(i);
                return ans;
            }
            map.put(prefixsum,i);
        }

        return ans;
    }

}
