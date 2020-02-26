package DP;

public class HouseRobber {
    public static void main(String[] args) {

    }

    public static long houserobber(int A[]) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = A[0];
        for (int i = 2; i <= n; i++) {
            f[i] = Math.max(f[i - 1], f[i - 2] + A[i - 1]);
        }

        return f[n];
    }


    public static long houserobber1(int A[]){
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        long[] f = new long[n + 1];
        f[0]=0;
        f[1]=A[0];
        f[2] = Math.max(f[1],f[0]+A[1]);
        for (int i = 2; i <= n; i++) {
            f[i]=Math.max(f[i-1],f[i-2]+A[i-1]);
        }
        return f[n];

    }
}
