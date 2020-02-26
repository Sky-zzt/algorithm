package Test;

public class jumpgame {
    public static void main(String[] args) {

    }

    public static boolean jump(int arr[]) {
        int length = arr.length;
      //  boolean f[]=new boolean[] [length];
       // f[0]=true;
        for (int i = 1; i < length; i++) {
            for (int j = 1; j <i ; j++) {
                if (j+arr[j]>=i){
                 //   f[i]=f[j]+arr[j];
                }
            }

        }

        return false;
    }
}
