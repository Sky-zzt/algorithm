package binarysearch;

import java.util.HashSet;
import java.util.PriorityQueue;

public class UglyNumberII {
    /*
    设计一个算法，找出只含素因子2，3，5 的第 n 小的数。

符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
     */
    public static int minuglynumber(int n) {
        if (n == 1) {
            return 1;
        }
        if (n < 1) {
            return -1;
        }
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
        PriorityQueue<Long> priorityQueue = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet<>();
        for (int j = 0; j < primes.length; j++) {
            priorityQueue.offer(primes[j]);
            set.add(primes[j]);
        }
        Long number = Long.valueOf(1);
        for (int i = 1; i < n; i++) {
            number = priorityQueue.poll();
            for (int j = 0; j < primes.length; j++) {
                if (!set.contains(primes[j] * number)) {
                    priorityQueue.offer(primes[j] * number);
                    set.add(primes[j] * number);
                }
            }
        }
        return priorityQueue.poll().intValue();

    }

}
