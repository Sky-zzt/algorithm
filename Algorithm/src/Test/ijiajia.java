package Test;

import java.util.Arrays;

public class ijiajia {
    public static void main(String[] args) {
        String painthouse = painthouse(new String("a- b"));
        System.out.println(painthouse);

    }

    public static  String painthouse(String s) {
        if (s==null||s.length()==0){
            return null;
        }
        char[] chars = s.toCharArray();
        reversr(chars,0,chars.length-1);
        return new String(chars);


    }
    public static void reversr(char [] chars,int i,int j){

        if (i<j){
            swap(chars,i,j);
            reversr(chars,i+1,j-1);
        }


    }
    public static void swap(char [] chars,int i,int j){
    char tmp;
    tmp=chars[i];
    chars[i]=chars[j];
    chars[j]=tmp;



    }
}
