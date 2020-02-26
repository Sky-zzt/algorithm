package DP;

public class BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {

    }
    public static int stock(int A[]){
int res=0;
        for (int i = 0; i < A.length-1; i++) {
            if (A[i+1]-A[i]>0){
                res+=A[i+1]-A[i];
            }
        }

        return res;
    }
}
