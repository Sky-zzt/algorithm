package depthsearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        List<Integer> permutation = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<>();
        helper(nums, permutation, set, results);

        return results;
    }

    // 1. 找到所有以permutation 开头的排列
    public void helper(int[] nums,  //不需要index 但是需要set 来保证自己不被重复选取
                       List<Integer> permutation,
                       Set<Integer> set,
                       List<List<Integer>> results) {
        // 3. 递归的出口
        if (permutation.size() == nums.length) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }
        // [3] => [3,1], [3,2], [3,4] ...
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }

            //去重
            if (i > 0 && nums[i - 1] == nums[i] || !set.contains(nums[i-1]) ){
                continue;
            }
            permutation.add(nums[i]);
            set.add(nums[i]);
            helper(nums, permutation, set, results);
            set.remove(nums[i]);
            permutation.remove(permutation.size() - 1);
        }

    }
}
