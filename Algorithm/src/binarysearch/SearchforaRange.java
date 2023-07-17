package binarysearch;

public class SearchforaRange {
    /**
     * 给定一个 排序数组nums (nums中有 重复 元素)与 目标值target ，如果
     * target在nums里 出现 ，则返回target所在区间的 左右端点下标 ，[左端点,
     * 右端点]，如果target在nums里 未出现 ，则返回[-1, -1]。
     *BinarySearchFirstPositionofTarget 以及 最后一个位置 ，执行两次即可
     * @param args
     */
    public static void main(String[] args) {

        for (int i : SFAR(new int[]{1, 2, 3, 4, 4, 6, 6, 6, 6, 6, 6}, 6)) {
            System.out.println(i);
        }

    }

    public static int[] SFAR(int[] arr, int target) {
        int[] f = new int[2];
        youduandian(arr, target, f);
        zuoduandian(arr, target, f);

        return f;
    }

    public static void youduandian(int arr[], int target, int f[]) {
        int index = -1;
        int length = arr.length;
        int low = 0;
        int high = length - 1;
        f[0] = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == arr[mid]) {
                if (mid == length - 1 || target < arr[mid + 1]) {
                    f[0] = mid;
                }
                low = mid + 1;
            } else if (target < arr[mid]) {


                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid + 1;

            }


        }
    }

    public static void zuoduandian(int arr[], int target, int f[]) {
        int index = -1;
        int length = arr.length;
        int low = 0;
        int high = length - 1;
        f[1] = 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == arr[mid]) {
                if (mid == 0 || target < arr[mid - 1]) {
                    f[1] = mid;
                }
                high = mid - 1;
            } else if (target < arr[mid]) {


                high = mid - 1;
            } else if (target > arr[mid]) {
                low = mid;

            }


        }
    }
}
