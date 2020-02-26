package Test;

public class binarysearch {


    public static void main(String[] args) {

    }
    public static void bs(int arr[],int start,int end,int K){
        int mid=start+(end-start)/2;
        if (start<end){
            if (K<=arr[mid]){
                bs(arr,start,mid,K);
            }else {
                bs(arr,mid+1,end,K);
            }


        }


    }
}
