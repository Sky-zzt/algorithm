package DP;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));

    }

    public static boolean jump(int arr[]) {
        if (arr == null || arr.length == 0)
            return false;
        boolean[] f = new boolean[arr.length];
        f[0] = true;
        for (int i = 1; i < arr.length; i++) {
            f[i] = false;
            for (int j = 0; j < i; j++) {
                if (f[j] && j + arr[j] >= i)
                    f[i] = true;
            }
        }
        return f[arr.length - 1];

    }
}
