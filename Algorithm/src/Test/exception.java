package Test;

import java.io.IOException;

public class exception {
    public static void main(String[] args) {
        System.out.println(he(0));
    }
    public static int  he(int i)throws ArrayIndexOutOfBoundsException {
        try {
            i=0;
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }
        return i;

    }



}
