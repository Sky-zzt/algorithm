package depthsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }

        Arrays.sort(nums);
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);

        return results;
    }

    private void dfs(int[] nums,
                     boolean[] visited,
                     List<Integer> permutation,
                     List<List<Integer>> results) {
        if (nums.length == permutation.size()) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static List<List<Integer>> permuteUnique1(int[] nums) {
        // write your code here

        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        helper(nums, results, new ArrayList<Integer>());
        return results;

    }

    public static void helper(int[] nums, List<List<Integer>> results, ArrayList<Integer> list) {

        if (list.size() == nums.length) {
            results.add(new ArrayList<Integer>(list));
            return;
        }
        //     results.add(new ArrayList<>(list));
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, results, list);
            list.remove(list.size() - 1);
        }

    }
}