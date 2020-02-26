package Test;

public class partition {
    public static void main(String[] args) {
        int[] ints = {1, 4, 7};
        int[] ints1 = {2,4,8};
        int[] ints2 = new int[ints.length + ints1.length-1];
        merge(ints,ints1,ints2);
        for (int i : ints2) {
            System.out.println(i);
        }

    }

    public static void quicksort(int arr[]){
        if (arr.length==0||arr==null){
            return;
        }
     //   quicksort();
    }
    public static void partition(int arr [],int target){
        int pre=-1;
        int current=0;
        int last=arr.length;
        while (current<last){
            if (arr[current]<target){
                swap(arr,++pre,current++);
            }else if (arr[current]>target){
                swap(arr,--last,current);
            }else {
                current++;
            }
        }


    }
    public static void merge(int arr[],int arr1[],int ints[]){
        int length = arr.length;
        int length1 = arr.length;
        int i=0;
        int j=0;
        int z=0;
      //  int[] ints = new int[length + length1];
        while (i<length&&j<length){
            if (arr[i]<arr1[j]){
                ints[z++]=arr[i++];
            }else {
                ints[z++]=arr1[j++];
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
