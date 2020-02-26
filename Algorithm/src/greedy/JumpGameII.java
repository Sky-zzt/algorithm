package greedy;

public class JumpGameII {
    public static void main(String[] args) {


    }

    public static int jump(int[] nums) {
        if (nums.length<2){
            return 0;
        }
        int curent_max_len = nums[0];
        int pre_max_len = nums[0];
        int jumpmin=1;


        for (int i = 1; i < nums.length; i++) {
            if (i>curent_max_len){
                jumpmin++;
                curent_max_len=pre_max_len;
            }

            if (pre_max_len<nums[i]+i){
                pre_max_len=nums[i]+i;
            }
        }
        return jumpmin;

    }
}

