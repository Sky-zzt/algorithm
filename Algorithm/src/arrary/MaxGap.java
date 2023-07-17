package arrary;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxGap {
    /**
     * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时
     * 间复杂度O(N)，且要求不能用非基于比较的排序。
     * 给定一个数组，求如果排序后，相邻两数的最大差值，要求复杂度为n，且不能基于比较的排序  建立一个桶  用到了桶
     *  、桶里只装最大值和最小值 桶的作用是确保最大差值一定不在桶的内部
     *  n个数 准备n+1个桶 最小值放在 0号桶 最大值放在n+1号桶  其他数放在自己对应的通里，比如9 放在9号桶
     *  70-79放在7号桶
     * boolen指示桶里有没有进去过数
     * 进去一个树 最大值和最小值都是这个数，
     * 若在进去 比较一下 更新最大最小值
     *     准备三个数组装min max boolean
     *
     * @param args
     */
    public static void main(String[] args) {

        int[] ints = {1, 4, 9, 2, 5, 12, 34, 56, 100};
        int maxgap = maxgap(ints);
        System.out.println(maxgap);
        System.out.println();

    }
    public static int maxgap(int[] nums) {
        ArrayList<Integer> integers = new ArrayList<>();

        if (nums == null || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }
//给定数组的最大值和最小值 以及数组的长度 确定 这个数num属于哪个范围
    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
