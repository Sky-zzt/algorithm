package recuriondivide;

public class  Pow {
    public static void main(String[] args) {
        int pow = (int) pow(3,8);
        System.out.println(pow);
        double pow1 = Math.pow(3, 8);
        System.out.println("--------------------");
        System.out.println(pow1);
        System.out.println();
    }

    public static int pow(int num,int low,int high) {//行不通
        int mid=(low+high)/2;
        int pow=1;
        if (low==high) {
           return num;
        } else if (low+1==high) {
            return num*num;
        }else {
           int a= pow(num,low,mid);
         int b=   pow(num,mid+1,high);
            return b*a;
        }
    }
    public static double pow(double num,double squ){ //注意对奇数偶数的判断
        //int mid=(int )squ/2;
        if (squ==1){
            return num;
        }else if(squ%2==0){
            double a = pow(num, squ/2);
            double b = pow(num, squ/2);
            return a*b;
        }else if (squ%2!=0){
            double a = pow(num, squ/2);
            double b = pow(num, squ/2);
            return num*a*b;

        }

return 0;
    }
}