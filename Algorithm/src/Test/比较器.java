package Test;

import arrary.LandFlag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 比较器 {

    int age;

    public 比较器(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    String name;

    public static void main(String[] args) {
        ArrayList<比较器> list = new ArrayList<>();
//        list.add(1);
//        list.add(-1);
//        list.add(10);
//        list.add(12);
//        list.add(3);

        比较器 比较器 = new 比较器(18, "a");
        比较器 比较器1 = new 比较器(18, "b");
        比较器 比较器2= new 比较器(18, "c");
//        list.add(比较器);
//        list.add(比较器2);
//        list.add(比较器1);
//        Collections.sort(list, new Comparator<比较器>() {
//            @Override
//            public int compare(Test.比较器 o1, Test.比较器 o2) {
//
//                return o1.getAge()-o2.getAge();
//            }
//        });
//        for (Test.比较器 比较器3 : list) {
//            System.out.println(比较器3);
//        }

//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });
//        System.out.println(list);
    }
}
