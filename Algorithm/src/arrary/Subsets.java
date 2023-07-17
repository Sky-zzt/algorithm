package arrary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        helper(new ArrayList<Integer>(), nums, 0, results, 0);
        return results;
    }


    // 递归三要素
    // 1. 递归的定义：在 Nums 中找到所有以 subset 开头的的集合，并放到 results
    private static void helper(ArrayList<Integer> subset,
                               int[] nums,
                               int startIndex,
                               List<List<Integer>> results, int i) {
        // 2. 递归的拆解
        // deep copy
        // results.add(subset);
        
        results.add(new ArrayList<Integer>(subset));

        for (i = startIndex; i < nums.length; i++) {
            // [1] -> [1,2]

            if (i > startIndex && nums[i] == nums[i - 1]){
                continue;
            }
                subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            helper(subset, nums, i + 1, results, i);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }

        // 3. 递归的出口
        // return;
    }

    public static void main(String[] args) {

        List<List<Integer>> subsets = subsets(new int[]{1, 2,2});

        for (int i = 0; i < subsets.size(); i++) {

            System.out.println(subsets.get(i));
        }
    }

/*
Description
中文
English
给定一个候选数字的集合 candidates 和一个目标值 target. 找到 candidates 中所有的和为 target 的组合.

在同一个组合中, candidates 中的某个数字不限次数地出现.
 */
public static  List<List<Integer>> combinationSum(int[] candidates, int target){
    if (candidates==null||candidates.length==0){
        return null;
    }
    List<List<Integer>> list = new ArrayList<>();
    helper(list,new ArrayList<Integer>(),0,candidates,target);
    return list;

}
    public static void  helper(List<List<Integer>> res,
                               ArrayList<Integer> list,
                               int pos,  //从数组的pos位置 开始 到他后面的数去选 加入到list
                               int [] nums,
                               int target
                               ){
        if (target==0){
            res.add(new ArrayList<>(list));
            return;
        }


        for (int i = pos; i <nums.length ; i++) {

            list.add(nums[i]);
            helper(res,list,i,nums,target-nums[i]);
            list.remove(list.size()-1);
        }


    }



}