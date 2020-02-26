package greedy;

public class RMBpay {
    public static void main(String[] args) {//贪心算法的一个例子，最少纸币张数凑金额
        int [] arr=new int[]{200,100,20,10,5,1};
        int num=arr.length;
        int x=325;
        int count=0;
        for (int i = 0; i <num ; i++) {
            int use=x/arr[i];
            count=count+use;
            x=x-arr[i]*use;
            System.out.println("需要面额为"+arr[i]+"的"+use+"张");
           // System.out.println();

        }
        System.out.println("总共需要  "+count);
    }
}
