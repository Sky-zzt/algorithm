package recuriondivide;

import java.util.*;

public class Subset {
    public static void main(String[] args) {
        System.out.println(new numsolution().subsets(new int[]{2,1, 2, 2}));

    }

}

class numsolution {
    public Set<List<Stack>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Stack>> result = new ArrayList<List<Stack>>();
        Set<List<Stack>> result1 = new HashSet<List<Stack>>();
        Stack<Integer> item = new Stack<>();
      //  result.add()

        generate(0, nums, result1, item);
        return result1;
    }

    private void generate(int i, int[] nums, Set<List<Stack>> result1,Stack item) {
        if (i > nums.length-1)
            return;
        item.add(nums[i]);
        result1.add(new ArrayList<Stack>(item));
        generate(i + 1, nums, result1, item);
        item.pop();
        generate(i + 1, nums, result1, item);
    }
}
