package binarysearch;

public class SearchinRotatedSortedArray {
    /**
     * 假设有一个排序的按未知的旋转轴旋转的数组(比如，0 1 2 4 5 6 7 可能成为4 5 6 7 0 1 2)。
     * 给定一个目标值进行搜索，如果在数组中找到目标值返回数组中的索引位置，否则返回-1。
     * 你可以假设数组中不存在重复的元素。
     *
     *
     *1.利用前面找最小值哪个  写两个二分
     * 2.画个图  你就知道  先看 每次二分的mid位置是落在 那边   确定落在那边后 要看 mid和target
     * 的关系  若 mid在左边且target<mid  你还要保证他大于大于左边第一个值
     *
     *
     *
     *
     *
     */



    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;
        int mid;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                // situation 1, red line
                if (A[start] <= target && target <= A[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // situation 2, green line
                if (A[mid] <= target && target <= A[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        } // while

        if (A[start] == target) {
            return start;
        }
        if (A[end] == target) {
            return end;
        }
        return -1;
    }

}
