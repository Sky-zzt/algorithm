package Test;

import java.util.HashSet;
import java.util.PriorityQueue;

public class NthUglyNUm {
    public static void main(String[] args) {


    }

    public static int Nth(int n) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        HashSet<Integer> set = new HashSet<>();
        int[] prim = new int[]{2, 3, 5};
        for (int i = 0; i < prim.length; i++) {
            queue.offer(prim[i]);
        }
        int min = 0;
        for (int i = 0; i < n; i++) {
            Integer poll = queue.poll();
            for (int j = 0; j < prim.length; j++) {
                if (!set.contains(prim[j] * poll)) {
                    queue.offer(prim[j]*poll);
                    set.add(prim[j]*poll);
                }
            }

        }
        return queue.poll();


    }
}
