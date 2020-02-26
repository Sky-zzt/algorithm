package DP;



public class CoinsinALine {
    public static void main(String[] args) {

    }
    public static boolean firstwillwin(int n){
        if(n==0)
        {
            return false;
        }
        if (n<=2){
            return true;
        }
        boolean[] f = new boolean[n + 1];
        f[0]=false;
        f[1]=f[2]=true;
        for (int i = 3; i <=n ; i++) {
            f[i]=(f[i-1]==false)||(f[i-2]==false);
        }
        return f[n];
    }




    }

