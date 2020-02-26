package DP;

public class BackpackVI {
    public static void main(String[] args) {

    }
    public static int backpack(int A[],int T){
        int[] f = new int[T + 1];
        f[0]=0;
        for (int i = 1; i <=T ; i++) {
            f[i]=0;
            for (int j = 0; j <A.length ; j++) {
                if (i>=A[j]){
                    f[i]+=f[i-A[j]];
                }
            }
        }


        return f[T];
    }
}
