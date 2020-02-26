package Test;

public class dpcoins {
    public static void main(String[] args) {

    }

    public static int lesscoins(int arr[], int sum) {

        int f[] = new int[sum + 1];
        f[0] = 0;
        int i;
        for (i = 1; i < f.length; i++) {
            f[i] = Integer.MAX_VALUE;
            //选择硬币
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] <= i) {
                    f[i] = f[i - arr[j]] + 1;
                }
            }
        }
        return f[i];
    }
}
