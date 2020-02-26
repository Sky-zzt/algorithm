package arrary;

public class MoveZeroes {
//双指针，left代表新数组，right代表老数组
    /*
    输入: nums = [0, 1, 0, 3, 12],
输出: [1, 3, 12, 0, 0].
     */
    public void moveZeroes(int[] nums) {
        // Write your code here
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;
        }
    }
}
