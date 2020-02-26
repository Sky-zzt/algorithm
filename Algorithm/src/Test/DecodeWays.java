package Test;

public class DecodeWays {
    public static void main(String[] args) {


    }

    public static int decode(String ss) {

        int m = ss.length();
        char[] chars = ss.toCharArray();

        int[] f = new int[m + 1];
        f[0] = 1;
        for (int i = 1; i <= m; i++) {
            f[i] = 0;
            int t =chars[i-1]-'0';
            if (t>=1&&t<=9){ //防止大于26 小于1
                f[i]+=f[i-1];
            }else {
                int k=(chars[i-2]-'0')*10+(chars[i-1]-'0');
                if (k>=1&&k<=26){
                    f[i]+=f[i-2];
                }
        }

    }
        return f[m];

}
}
