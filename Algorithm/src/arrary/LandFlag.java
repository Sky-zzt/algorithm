package arrary;

public class LandFlag {
    public static void main(String[] args) {
        int[] arr=new int []{2,3,7,1,9,2,5,5,6,75,5,5,0,3,7,100};
        int[] langflag = langflag(0, arr.length - 1, arr, 5);
        for (int i = 0; i <langflag.length ; i++) {
            System.out.print(" ");
            System.out.print(langflag[i]);

        }

        int i=99;
        i=-i;
        System.out.println(i);

    }
public static int [] langflag(int low, int high, int[] arr, int num){
        int less=low-1;
        int more=high+1;
        int index=low;
    while (index < more) {
        if (arr[index]<num){
            int temp=arr[++less];
            //arr[++less]=arr[index];又加加了一遍
            arr[less]=arr[index];
            arr[index]=temp;
            index++;
        }else if (num<arr[index]){
            int temp=arr[--more];
            arr[more]=arr[index];
            arr[index]=temp;

        }else {
            index++;

        }

    }
        return arr;


}

}
