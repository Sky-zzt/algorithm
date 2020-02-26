package arrary;

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {

    }

    public static double findMedianSortedArrays(int A[], int B[]) {
        int n = A.length + B.length;
        if (n % 2 == 0) {
            return (findKth(A, 0, B, 0, n / 2) + findKth(A, 0, B, 0, n / 2 + 1)) / 2.0;
        }
        return findKth(A, 0, B, 0, n / 2 + 1);
    }
    // find kth number of two sorted array
    /*
    找从小到大第k个数 你扔掉A或者B的k/2个数
     */
    //找从小到大第K个数
    public static int findKth(int[] A, int startOfA,
                              int[] B, int startOfB,
                              int k) {
        if (startOfA >= A.length) {   //A空了
            return B[startOfB + k - 1];
        }
        if (startOfB >= B.length) {
            return A[startOfA + k - 1];
        }
        if (k == 1) {
            return Math.min(A[startOfA], B[startOfB]);
        }
        int halfKthOfA = startOfA + k / 2 - 1 < A.length
                ? A[startOfA + k / 2 - 1]
                : Integer.MAX_VALUE;
        int halfKthOfB = startOfB + k / 2 - 1 < B.length
                ? B[startOfB + k / 2 - 1]
                : Integer.MAX_VALUE;
        if (halfKthOfA < halfKthOfB) {
            return findKth(A, startOfA + k / 2, B, startOfB, k - k / 2);
        } else {
            return findKth(A, startOfA, B, startOfB + k / 2, k - k / 2);
        }
    }
}
