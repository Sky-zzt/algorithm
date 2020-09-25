package DP;

import java.util.ArrayList;
import java.util.List;

public class Ksum {
    /**
     * @param A: the array A
     * @param k: the integer k
     * @param target: the integer target
     * @return: return the number of legal schemes
     */

    public int kSum(int[] A, int k, int target) {
        if (k > A.length) {
            return 0;
        }
        // 统计一下 odd和even的数目，然后分别dfs
        int odd = 0, even = 0;
        for (int i = 0; i< A.length; i++) {
            if (A[i] %2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        int[] odds = new int[odd];
        int[] evens = new int[even];
        int oi = 0, ei = 0;
        for (int i = 0; i< A.length; i++) {
            if (A[i]%2 == 0) {
                evens[ei] = A[i];
                ei++;
            } else {
                odds[oi] = A[i];
                oi++;
            }
        }

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        helper(odds, 0, k, target, ans, new ArrayList<Integer>());
        helper(evens, 0, k, target, ans, new ArrayList<Integer>());
        return ans.size();
    }

    public void helper(int[] A, int start, int k, int target, List<List<Integer>> ans, List<Integer> list) {
        if (target == 0) {
            if (list.size() == k) {
                ans.add(new ArrayList<Integer>(list));
            }
            return;
        }
        if (list.size() >=k) {
            return;
        }
        for (int i = start; i< A.length; i++) {
            list.add(A[i]);
            helper(A, i+1, k, target - A[i], ans, list);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {


    }
}