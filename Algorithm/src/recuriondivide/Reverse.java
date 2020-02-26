package recuriondivide;



import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {

        int[] arr = {1,7,8,9,0,12,65,80};
        reverse(arr,0,arr.length-1);
       // he(arr);
        System.out.println(Arrays.toString(arr));
    }
    public  static  void reverse(int arr[],int low,int high){

        if(low<high){
            swap(arr,arr,low,high);
            reverse(arr,low+1,high-1);

        }

    }
    public static void swap(int arr[], int arr1[],int low ,int high ){
        int temp=arr[low];
        arr[low]=arr1[high];
        arr1[high]=temp;
    }


}
