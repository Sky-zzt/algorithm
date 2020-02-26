package recuriondivide;

public class RecursonSum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int sum = sum(arr, 7);
        System.out.println(sum);
        System.out.println(sum(7));
    }

    public static int sum(int a[], int n) {
        return n < 1 ? 0 : sum(a, n - 1) + a[n - 1];  //减而之治  还可以分为两半  分而之治

    }

    public static int sum(int a) {
        if (a == 0) {
            return 0;
        }
        if (a == 1) {

            return 1;
        }
        if (a==2){
            return 3;
        }

        return sum(a - 1) + a;


    }
}
