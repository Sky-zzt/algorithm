package binarysearch;

public class FindPeakElement {
    /*

    你给出一个整数数组(size为n)，其具有以下特点：

    相邻位置的数字是不同的
    A[0] < A[1] 并且 A[n - 2] > A[n - 1]
    假定P是峰值的位置则满足A[P] > A[P-1]且A[P] > A[P+1]，返回数组中任意一个峰值的位置。
    至少三个数 有峰  返回一个即可


     */
    public int findPeak(int[] A) {
        // write your code here
        int start = 1, end = A.length - 2; // 1.答案在之间，2.不会出界
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (A[mid] < A[mid - 1]) {
                end = mid;
            } else if (A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }


    public static int findpeak(int A[]) {

        if (A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while (start+1<end){
            int mid = start+(end - start)/2;
            if (A[mid]>A[mid+1]){
                end=mid;
            }else {
                start=mid;
            }
        }
        return Math.max(A[start],A[end]);


    }
}
