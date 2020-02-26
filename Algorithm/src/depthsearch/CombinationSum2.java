package depthsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

给定一个数组 num 和一个整数 target. 找到 num 中所有的数字之和为 target 的组合.

在同一个组合中, num 中的每一个数字仅能被使用一次.
所有数值 (包括 target ) 都是正整数.
返回的每一个组合内的数字必须是非降序的.
返回的所有组合之间可以是任意顺序.
解集不能包含重复的组合.
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null) {
            return results;
        }
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);//排序是前提 别忘了
        helper(candidates, target, combination, results);
        return results;

    }

    public static void helper(int nums[],
                              int target,

                              List<Integer> combination,
                              List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            if (combination.contains(nums[i])) {
                //这里不学subset2用i！=startindex  是因为 helper是startindex没加一
                continue;
            }
            combination.add(nums[i]);
            helper(nums, target - nums[i], combination, results);//target-nums[i]可能会变负数
            combination.remove(combination.size() - 1);
        }
    }
}
