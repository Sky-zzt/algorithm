package recuriondivide;

public class FindmaximumandSubmaximum {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 10};
        int[] arr1 = new int[1];
        int[] arr2 = new int[1];
        maxsubmaximum(arr, 0, arr.length - 1, arr1, arr2);
        System.out.println("------------------");
        System.out.println(arr1[0] + "  " + arr2[0]);

    }

    public static void maxsubmaximum(int[] arr, int low, int high, int max[], int submax[]) {
        if (low == high) {
            max[0] = arr[low];
            submax[0] = arr[high];

        } else if (low + 1 == high) {
            if (arr[low] > arr[high]) {
                max[0] = arr[low];
                submax[0] = arr[high];
            } else {
                max[0] = arr[high];
                submax[0] = arr[low];

            }
        } else {
            int[] lmax = {0};
            int[] rmax = {0};
            int[] lsubmax = {0};
            int[] rsubmax = {0};
            int mid = (low + high) / 2;
            maxsubmaximum(arr, low, mid, lmax, lsubmax);
            maxsubmaximum(arr, mid + 1, high, rmax, rsubmax);
            if (lmax[0] > rmax[0]) {
                max[0] = lmax[0];
                submax[0] = lsubmax[0] > rmax[0] ? submax[0] : rmax[0];

            } else {
                max[0] = rmax[0];
                submax[0] = rsubmax[0] > lmax[0] ? rsubmax[0] : lmax[0];

            }


        }
        System.out.println(max[0] + "  " + submax[0]);


    }
}
