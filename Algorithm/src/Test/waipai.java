package Test;

public class waipai {
    public static void main(String[] args) {

        int[] waipai = waipai(new int[]{1, 5, 7}, new int[]{ 2,7,8,9,10});
        for (int i : waipai) {
            System.out.println(i);
        }
    }
    public static  int[] waipai(int arr[],int arr1[]){

        int i=0;
        int j=0;
        int k=0;
        int[] ints = new int[arr1.length + arr.length];
        while (i<arr.length&&j<arr1.length) {
            if (arr[i] >= arr1[j]) {
                ints[k++] = arr1[j];
                j++;
            } if (arr[i] <arr1[j]){
                ints[k++] = arr[i];
                i++;

            }
        }
            int cha=arr.length-i;
            int cha1=arr1.length-j;


            while (cha!=0){
                ints[k++]=arr[i++];
                cha--;
            }
            while (cha1!=0){
                ints[k++]=arr1[j++];
                cha1--;
            }



return ints;
    }
}
