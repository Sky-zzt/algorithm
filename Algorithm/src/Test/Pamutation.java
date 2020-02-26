package Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pamutation {

    public static void main(String[] args) {


    }

    public static List<List<Integer>> pamutatiaon(int arr[]) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(arr, set, result, list);
        return result;
    }
    public static void helper(int arr[],
                              Set<Integer> set,
                              List<List<Integer>> result,
                              List<Integer> list) {
        if (list.size() == arr.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);
            list.add(arr[i]);
            helper(arr, set, result, list);
            set.remove(arr[i]);
            list.remove(list.size() - 1);
        }
    }
}
