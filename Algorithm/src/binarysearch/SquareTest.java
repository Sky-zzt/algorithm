package binarysearch;

import javax.sound.midi.MidiChannel;
import java.math.BigInteger;

public class    SquareTest {

    private float e0;

    public static void main(String[] args) {
        //  System.out.println(sqrtNewton(100, (float) 1));
        //  System.out.println(sqrt1(10000,  0.001));
        System.out.println(sqrtNewton(1000, (float) 0.001));

    }

/*
牛顿迭代公式
Xn+1=Xn-f(x)/f'(x)

对与平方根

f(x)=X2 = a     带入牛顿迭代公式即可
 */
    private static float sqrtNewton(float num, float e) {
        float mid = num / 2;
        while (num < mid * mid) {
            mid = (mid + num / mid) / 2;

        }
        return mid;
    }


    public static double sqrt1(int num, double e) {
        double low = 0;
        double high = num;
        double mid = 0;
        double e1 = 1;
        while (e1 > e) {
            mid = (low + high) / 2;
            if (mid * mid > num) {
                high = mid;

            } else if (mid * mid < num) {
                low = mid;
            }
            e1 = Math.abs(mid * mid - num);//记得绝对值

        }


        return mid;
    }


}

