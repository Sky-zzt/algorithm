package DP;

public class LongestIncreasingContinuousSubsequence {
    public int result = 0;
    public void calc(int[] arr, int n) {
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;//不可=0
            if (i > 0 && arr[i - 1] < arr[i]) {
                f[i] = f[i - 1] + 1;
            }
            if (f[i] > result) {
                result = f[i];
            }
        }
    }
    public static void main(String[] args) {
    }
    public int lics(int arr[]) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }
        calc(arr,n);
        int i, j, t;
        i = 0;
        j = n - 1;
        //reverse array
        while (i < j) {
            t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            ++i;
            --j;
        }
        calc(arr, n);
        return result;
    }
}
