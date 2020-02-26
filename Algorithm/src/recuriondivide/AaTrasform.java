package recuriondivide;

public class AaTrasform {
    public static void main(String[] args) {
        char[] ch={'A','B','C','D','E','F','G','H'};
      //  trasform(ch,ch.length-1);
        trasformrecur(ch,0,ch.length-1);




    }
    public static void trasform(char ch[],int i){//递归
   //     int i=ch.length-1;
        if (i>=0) {
            System.out.println((char) (ch[i] + 32));
            i--;
            trasform(ch,i);
        }
    }
    /*
    divide and conquer
     */
    public static void trasformrecur(char ch[],int low,int high){

        int mid=(low+high)/2;
        if (low==high){
            System.out.print((char)(ch[high]+32));

        }else {
            trasformrecur(ch, low, mid);
            trasformrecur(ch, mid + 1, high);
        }
    }

}
