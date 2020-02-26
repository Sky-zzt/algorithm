package Sort;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = {1, 5, 4,-1,8,9,100,23,56,200,12, 3, 1, 2};
       heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static void heapinsert(int arr[]) {//创建大堆
        // int index=0;
        for (int i = 0; i < arr.length; i++) {
            while (true) {  //可以写为while arr[i] < arr[(i - 1) / 2]
                if (arr[i] > arr[(i - 1) / 2]) {
                    swap(arr, i, (i - 1) / 2);
                    i = (i - 1) / 2;

                } else if (arr[i] < arr[(i - 1) / 2]) {
                    break;
                } else if (arr[i] == arr[(i - 1) / 2]) {
                    break;
                }
            }
        }

    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void heapify(int arr[], int index, int heapsize) {//原本的大堆其中一个数变了，如何调整   这个方法不行
        int left = index * 2 + 1;//左孩子
        while ((2 * index + 1 < arr.length) && (2 * index + 2 < arr.length)) {
             int max = Math.max(arr[2 * index + 1], arr[2 * index + 2]);//我的问题处在没有用下表 记住不要用数组值
            int largest = left + 1 /*右孩子*/ < heapsize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (max > arr[index]) {
                int tmep = max;
                if (arr[2 * index + 1] < arr[2 * index + 2]) {
                    arr[2 * index + 2] = arr[index];
                } else {
                    arr[2 * index + 1] = arr[index];
                }
                arr[index] = tmep;
            } else {
                break;
            }
            //  arr[index]=arr[index]<max?max:arr[index];
            index = arr[2 * index + 1] > arr[2 * index + 2] ? 2 * index + 1 : 2 * index + 2;  //此时的arr已经是交换过的了


        }
    }

    public static void heapify1(int[] arr, int index, int heapsize) {//heapsize是数组中是大堆的部分，小于等于数组长度
        int left = index * 2 + 1;//左孩子
        while (left < heapsize) {
            int largest = left + 1 /*右孩子*/ < heapsize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapsort(int arr[]) {

        heapinsert(arr);
        int heapsize=arr.length;
        swap(arr,0,--heapsize);
        while (heapsize>0){
            heapify1(arr,0,heapsize);
            swap(arr,0,--heapsize);
        }
    }
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify1(arr, 0, size);
            swap(arr, 0, --size);
        }
    }


}
