package binarysearch;

public class SearchInsertPosition {
    /*
    给定一个 排序数组nums( 无重复元素) 与 目标值target ，如果target在nums里
出现 ，则返回 target 所在下标 ，如果target在nums里 未出现 ，则返回target 应该
插入位置 的数组下标，使得将target插入数组nums后，数组仍 有序 。

找到第一个大于等于target的数  有可能找不到
     */
    public static void main(String[] args) {
        System.out.println(SIP(new int[]{1,2,3,4,5},0));

    }
    public static int SIP(int [] arr,int targrt){
        int index=-1;
        int low=0;
        int high=arr.length;

        while (index==-1){
            int mid=(low+high)/2;
            if (targrt==arr[mid]){
                index=mid;
            }else if (targrt<arr[mid]){
                if (mid==0||targrt>arr[mid-1]) {  ///\没有mid==0就会有异常 所以要加
                    index = mid;
                }
                high=mid-1;
            }else if (targrt>arr[mid]){
                if (mid==arr.length-1||targrt<arr[mid+1]){

                    index=mid+1;
                }
                low=mid+1;
            }



        }

return index;


    }

}
