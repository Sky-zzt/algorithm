package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveKdigitals {
    public static void main(String[] args) {

        System.out.println(removedigitals("1234", 1));
    }

    public static String removedigitals(String s, int k) {
        char[] chars = s.toCharArray();
        ArrayList<Character> objects = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            objects.add(chars[i]);
        }

        while (k != 0) {
            for (int i = 0; i < objects.size() - 1; i++) {
                int num = objects.get(i) - '0';
                int num1 = objects.get(i + 1) - '0';
                if (num >= num1) {
                    objects.remove(i);
                    k--;
                    break;
                }
            }
        }


        return objects.toString();
    }
}
