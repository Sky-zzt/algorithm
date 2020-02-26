package DP;

public class CountingBits {
    public static void main(String[] args) {

    }
    public static int[] cb(int num){
        int[] f = new int[num + 1];
        f[0]=0;
        for (int i = 1; i <=num ; i++) {
            f[i]=f[i>>1]+(i%2);
        }
return f;
    }
}
