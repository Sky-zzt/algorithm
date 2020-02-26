package Test;

public class quick {
    public static void main(String[] args) {

        int[] ints = {3, 2, 4,1};
        sortIntegers1(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    public static void sortIntegers(int[] A) {
        // write your code here

        if (A == null || A.length < 2) {
            return;
        }

        quicksort(0, A.length - 1, A);


    }

    public static void quicksort(int start, int end, int arr[]) {
        if (start < end) {
            int[] p = partition(start, end, arr, arr[start + (int) (Math.random() * (end - start + 1))]);
            quicksort(start, p[0], arr);
            quicksort(p[1], end, arr);
        }
    }

    public static int[] partition(int left, int right, int[] arr, int k) {
        int less = left - 1;
        int more = right + 1;
        while (left < more) {
            if (arr[left] < k) {
                swap(arr, left++, ++less);
            } else if (arr[left] > k) {
                swap(arr, left, --more);
            } else {
                left++;
            }

        }

        return new int[]{less, more};


    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    public static void sortIntegers1(int[] A) {
        // write your code here

        if(A==null||A.length<2){
            return ;
        }

        mergesort(0,A.length-1,A);


    }
    public static void mergesort(int start,int end ,int [] A){
        if(start<end){
            int mid=start+(end-start)/2;

            mergesort(start,mid,A);
            mergesort(mid+1,end,A);
            merge(start,mid,end,A);

        }

    }

    public static void merge(int start,int mid,int end,int[]arr){
        int [] help=new int [end-start+1];
        int i=start;
        int j=mid+1;
        int index=0;
        while(i<=mid&&j<=end){
            if(arr[i]<arr[j]){
                help[index++]=arr[i++];
            }else {
                help[index++]=arr[j++];

            }
        }
        while(i<=mid){
            help[index++]=arr[i++];
        }
        while(j<=end){
            help[index++]=arr[j++];
        }


        for (int k=0;k<help.length ;k++ ){
            arr[k]=help[k];


        }

    }
}