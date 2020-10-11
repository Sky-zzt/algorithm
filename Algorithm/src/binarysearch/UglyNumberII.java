package binarysearch;

import java.util.HashSet;
import java.util.Objects;
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
        long[] primes = new long[3];
        primes[0] = 2L;
        primes[1] = 3L;
        primes[2] = 5L;
        PriorityQueue<Long> priorityQueue = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet<>();
        for (Long prime : primes) {
            priorityQueue.offer(prime);
            set.add(prime);
        }
        Long number = 1L;
        for (int i = 1; i < n; i++) {
            number = priorityQueue.poll();
            for (Long prime : primes) {
                if (!set.contains(prime * number)) {
                    priorityQueue.offer(prime * number);
                    set.add(prime * number);
                }
            }
        }
        return Objects.requireNonNull(priorityQueue.poll()).intValue();

    }

}
