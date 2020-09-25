package DP;

public class DecodeWays {
    public static void main(String[] args) {
decodeways(new String("12"));
    }
    public static int decodeways(String ss){
        char[] s = ss.toCharArray();
        int n = s.length;
        if (n==0){
            return 0;
        }
        int[] f = new int[n + 1];
        f[0]=1;
        //前i个数字
        for (int i = 1; i <=n ; i++) {
           f[i]=0;
           //last digital
           int t=s[i-1]-'0';
           if (t>=1&&t<=9){ //防止大于26 小于1
               f[i]+=f[i-1];
           }
           //len must greater than 2
            if (i>=2){
                //last two digital
                t=(s[i-2]-'0')*10+(s[i-1]-'0');
                if (t>=10&&t<=26){
                    f[i]+=f[i-2];
                }
            }
        }
        return f[n];
    }
}
