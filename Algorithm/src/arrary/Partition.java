package arrary;

public class Partition {
    public static int[] partion(int[] arr, int target) {
        int begin = 0;
        int end = arr.length - 1;
        while (begin <= end) {
            while (begin<=end&&arr[begin]<target){
                begin++;
            }
            while (begin<=end&&arr[end]>target){
                end--;
            }
            if (begin<=end){
                swap(arr,begin,end);
                begin++;
                end--;
            }
        }
        return arr;
    }
//荷兰国旗问题相当于三根指针 less more l
    public static int[] partition(int[] arr, int l, int r, int p) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (arr[l] < p) {
                swap(arr, ++less, l++);
            } else if (arr[l] > p) {
                swap(arr, --more, l);
            } else {
                l++;
            }
        }
        return arr; //返回等于区域是哪个范围
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] partion = partition(new int[]{0, 2, 1, 0, 2, 1, 0},0,6,1);
//        for (int i : partion) {
//            System.out.println(i);
//        }
        int[] partion1 = partion(new int[]{0, 2, 1,0, 2, 1, 0},1);
        for (int i : partion1) {
            System.out.println(i);
        }
    }

    }

