package Test;

public class prefixsumTest {
    public static void main(String[] args) {


    }
    public static int prefixsum(int arr[]){
        if (arr==null){
            return -1;
        }
        int sum=0,max=0,minsum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
             max = Math.max(max, sum - minsum);
             minsum=Math.min(minsum,sum);

        }

        return max;
    }
}
