package binarysearch;

public class   SearchInaBigSortedArray {
/*
题意：给一个按照升序排序的正整数数组。这个数组很大以至于只能通过固定的接口ArrayReader->get(k)来访问第k个数。
并且也没有办法得知这个数组有多大。找到给出的整数target第一次出现的位置。
你的算法需要在O(logk)的时间复杂度内完成，k为target第一次出现的位置的下标。如果找不到target，返回-1。

思路：倍增找到第一个大于target的位置，然后二分
 */
//在此 我们假设不知道arr的长度 他也没有arr.length方法
public static int SearchInaBigSortedArray(int []arr,int target){
    //倍增
    if (arr[0]==target){
        return 0;
    }
    int len=1;
    while (arr[len]<target){
        len=len*2;
    }
    //二分

    int start = len/2;
    int end =len-1;



return 0;
}
}
