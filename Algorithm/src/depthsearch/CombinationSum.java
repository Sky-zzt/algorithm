package depthsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
/*
给定一个候选数字的集合 candidates 和一个目标值 target. 找到 candidates 中所有的和为 target 的组合.

在同一个组合中, candidates 中的某个数字不限次数地出现.

所有数值 (包括 target ) 都是正整数.
返回的每一个组合内的数字必须是非降序的.
返回的所有组合之间可以是任意顺序.
解集不能包含重复的组合.
 */

    }

    public static List<List<Integer>> combinationSum(int candidates[], int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null) {
            return results;
        }
        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);//排序是前提 别忘了
        helper(candidates, target,0,  combination, results);
        return results;

    }

    public static void helper(int nums[],
                              int target,
                              int startIndex,
                              List<Integer> combination,
                              List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }


        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                //这里不学subset2用i！=startindex  是因为 helper是startindex没加一
                continue;
            }
            combination.add(nums[i]);
            helper(nums, target - nums[i],i, combination, results);//target-nums[i]可能会变负数
            //startindex用i  若是combinationsum2  则是i+1   从来都没有startindex+1
            combination.remove(combination.size() - 1);
        }

    }
}
