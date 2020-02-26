package Test;

import stringopreation.KMP;

import java.util.BitSet;

public class bloom {
    public static void main(String[] args) {

        int[] ints = new int[9];
        System.out.println(ints[8]);
        ints [8]=(ints[8] | (1<<16));  //huo运算
        String s = Integer.toBinaryString(ints[8]);
        String s1 = Integer.toBinaryString(0);
        System.out.println(s1);
        System.out.println(s);
        BitSet bitSet = new BitSet(10);
        System.out.println(bitSet);

        BitSet bitSet1 = new BitSet();



    }
}
