package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null) {
            return result;
        }

        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0, target, combination, result);

        return result;
    }

    void helper(int[] candidates,
                int index,
                int target,
                List<Integer> combination,
                List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }

            if (i>0 && candidates[i] == candidates[i - 1]) {
                continue;
            }

            combination.add(candidates[i]);
            helper(candidates, i, target - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        new Solution().combinationSum(new int[]{2,3,6,7},7);
    }
}