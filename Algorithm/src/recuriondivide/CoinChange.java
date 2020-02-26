package recuriondivide;

import static java.lang.Integer.MAX_VALUE;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(f(27));
    }

    public static int f(int  X){
        if (X == 0) return 0;
        if (X==1) return MAX_VALUE;
        //if (X==2) return 1;
       // if (X==3) return 0;
       // if (X==4) return 2;
        //if (X==5) return 1;
     //   if (X==6) return 0;
        //if (X==7) return 1;
      //  if ()
        int res = MAX_VALUE;
        if (X >= 2) {
            res = Math.min(f(X-2) + 1, res);
        }
        if (X >= 5) {
            res = Math.min(f(X-5) + 1, res);
        }
        if (X >= 7) {
            res = Math.min(f(X-7) + 1, res);
        }
        return res;



    }
}
