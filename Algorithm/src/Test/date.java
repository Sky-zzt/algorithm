package Test;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class date {
    public static void main(String[] args){
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String str =
                "2019/03/02";
        int result = index(str);
        System.out.println(result);
    }

    public static int index(String date){
        //2016/03/24
        String[] arr = date.split("/");
        /*for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }*/
        int mdays = 0;
        int x = 0;
        for(int i = 1;i < Integer.parseInt(arr[1]);i++){
            switch(i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    x = 31;
                    break;
                case 2:
                    x = isRun(arr[0])? 29 : 28;
                    break;
                default:
                    x = 30;
            }
            mdays = mdays + x;
        }

        int days = mdays + Integer.parseInt(arr[2]);
        return days;
    }

    public static boolean isRun(String s){
        int year = Integer.parseInt(s);
        if((year%4 == 0 && year%100 != 0)|| year%400 == 0)
        return true;
        return false;
    }

}
