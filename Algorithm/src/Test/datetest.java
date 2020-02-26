package Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class datetest {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        long time = date.getTime();//System.currentTimeMillis() 一样
    //    System.out.println(time);
        String dateFormat = new SimpleDateFormat ("yyyy.MM.dd HH.mm.ss.SSS").format(date);
        String s="2019.09.15 10.45.47.152";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH.mm.ss.SSS");
       Date parse = simpleDateFormat.parse(s);
        System.out.println(parse);

       // System.out.println(dateFormat);


        Calendar instance = Calendar.getInstance();
        int i = instance.get(Calendar.DATE);
        instance.set(Calendar.YEAR,1908);
        System.out.println(instance.get(Calendar.YEAR));
        System.out.println(i);

        GregorianCalendar calendar = new GregorianCalendar();// Calendar instance = Calendar.getInstance();得到一个GregorianCalendar对象
        calendar.setTime(date);
     //   calendar.add(calendar.DATE,1);
        calendar.add(calendar.DATE,0); //把我指定的字段增加或减少
        date=calendar.getTime(); //转成date 方便  calendar 只返回一个 不好

      //  System.out.println(date);
    //    System.out.println(calendar);
        String format = new SimpleDateFormat("yyyyMMdd").format(date);
   //     System.out.println(format);
        System.out.println(System.currentTimeMillis()-time+"毫秒");

        }
    }

