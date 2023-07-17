package arrary;

public class FindNumAppearInTwoarrary {
    public static void main(String[] args) {
        int[] arr = new int[]{11, 21, 31, 41, 51, 61, 71};//两个排好序的数组中都出现的数  找出b数组a中没出现的数也一样
        int[] arr1 = {2, 41, 61, 80};
        findNumAppearIntwoarrary(arr, arr1);

    }

    public static void findNumAppearIntwoarrary(int arr[], int arr1[]) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (Math.max(arr.length,arr1.length)>k) {
            k++;
            if (arr[i] < arr1[j]) {
                i++;
            } else if (arr[i] == arr1[j]) {
                System.out.println(arr[i]);
                j++;
            }
            if (arr[i] > arr1[j]) {
                j++;
            } else if (arr[i] == arr1[j]) {
                System.out.println(arr[i]);
                i++;
            }
        }


    }
}
