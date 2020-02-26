package DP;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class MaxIncreacingSbusques {
    public static void main(String[] args) {
       // Collections.sort();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                dp[i] = arr[i];
            }
            for (int i = 0; i < n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], arr[i] + dp[j]);
                    }
                }
            }
            int max = dp[0];
            for (int i = 1; i < n; i++) {
                max = Math.max(max, dp[i]);
            }
            System.out.println(max);

        }
    }

}
