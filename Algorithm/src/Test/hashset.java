package Test;

import java.util.HashSet;

public class hashset {
    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(12);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}
