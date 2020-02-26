package Test;

public class rmbpay {
    public static void main(String[] args) {
        System.out.println(rnb(new int[]{200,100,20,10,5,1},625));
    }

    public static int rnb(int[] arr, int count) {
        int use=0;

        for (int i = 0; i < arr.length; i++) {
                use+=count/arr[i];
                int use1=count/arr[i];
                count=count%arr[i];

        }
return use;

    }
}
