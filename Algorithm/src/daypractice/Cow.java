package daypractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cow {

    public static void main(String[] args) {

String s="122233";
String s1="AT12";
        int[] bet = bet(s, s1);
        System.out.println(Arrays.toString(bet));

    }

    public static  int[] bet(String str1, String str2) {
        int []  total=new int[2];
        int[] ints = trasform(str1);
        int s = 0;
        int s1=0;
        for (int i = 0; i < ints.length; i++) {
            s = s + ints[i];

        }
        int[] ints1 = trasform(str2);
        for (int i = 0; i <ints1.length; i++) {
            s1=s1+ints1[i];

        }
        total[0]=s;
        total[1]=s1;
        return total;

    }

    public static int[] trasform(String str) {
        char[] arr = str.toCharArray();

        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'A') {
                a[i] = 1;

            }
            if (arr[i] == 'T') {
                a[i] = 10;

            }
            if (arr[i] == 'Q') {
                a[i] = 1;

            }
            if (arr[i] == 'K') {
                a[i] = 10;

            }
            if (arr[i] == 'J') {
                a[i] = 10;

            }
            if (arr[i] == '2') {
                a[i] = 2;

            }
            if (arr[i] == '3') {
                a[i] = 3;

            }
            if (arr[i] == '4') {
                a[i] = 4;

            }
            if (arr[i] == '5') {
                a[i] = 5;

            }
            if (arr[i] == '6') {
                a[i] = 6;

            }
            if (arr[i] == '7') {
                a[i] = 7;

            }
            if (arr[i] == '8') {
                a[i] = 8;

            }
            if (arr[i] == '9') {
                a[i] = 9;

            }

        }


        return a;
    }
}
