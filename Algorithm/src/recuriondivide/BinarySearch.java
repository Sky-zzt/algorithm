package recuriondivide;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        Boolean aBoolean = new Boolean(false);

      int bs = BS(new int[]{1, 2, 3, 4}, 4, 0, 3);
        System.out.println(bs);

    }
//    public static int bs(int arr[],int target){
//        int low=0;
//        int
//        return BS(arr,target,)
//    }

    public static int  BS(int[] arr, int target, int low, int high) {
        //求中间元素的下标
        int mid = (low + high) / 2;
        //数组内不含有指定元素，依据下标的规则，退出
        if (low > high)
            return -1;
        //查找到指定元素
        if (target == arr[mid]) {
            return mid;
            //当查找的元素大于中间下标的元素，则改变开始下标的位置
        } else if (target > arr[mid]) {
            return BS(arr, target, mid + 1, high);
        } else {
            //当查找的元素小于中间下标的元素，则改变结束下标的位置
            return BS(arr, target, low, mid - 1);
        }

       




    }
}
