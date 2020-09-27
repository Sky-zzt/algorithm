package binarysearch;

public class FindMinimumnRotatedSortedArray {
/*
假设一个排好序的数组在其某一未知点发生了旋转（比如0 1 2 4 5 6 7 可能变成4 5 6 7 0 1 2）。你需要找到其中最小的元素。
无重复元素

考点：二分
题解：使用target记录数组最右端的数字，
然后用start和end标志寻找区间，如果mid位置上的数字小于等于最右端的数字时，区间向左移动，
其余向右移动即可，返回start和end位置上较小值即可

因为这是个旋转排序数组，所以第一个小于最右边的值，一定是最小值。而找到这个最小值的方法就是利用二分法，
把最右边的值设成target，
1.如果med的值大于最右边，则说明我们要找的值在med右边，所以start=med；
2.如果med的值小于最右边，则说明我们要找的值在med左边，所以end=med;
3.如果med=最右边，个人感觉就无所谓了，因为这个不重复，所以你可以随便给一边，因为只会start和end肯定相邻了。


 */
//【1】
//有相等的数  只能for 然后 On【2，2，2，2，2，2，2，2，2，2，2，2，2，1，2，2，2，2，2，2，2】
public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
        return -1;
    }

    int start = 0, end = nums.length - 1;
    int target = nums[nums.length - 1];

    // find the first element <= target
    while (start + 1 < end) {    		//用来控制区间大小
        int mid = start + (end - start) / 2;
        if (nums[mid] < target) { 		//如果mid位置上的数字小于等于最右端的数字时，区间向左移动
            end = mid;
        } else {
            start = mid;
        }
    }
    return Math.min(nums[start],nums[end]);  //最终返回start和end位置上较小的数字即可

}
}
