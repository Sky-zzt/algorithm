package DP;

public class longestPalindromeSout {
    public static void main(String[] args) {

        System.out.println(longestPalindrome2("bbbab"));
    }

    public static String longestPalindrome2(String s) {

        if (null == s || s.length() <= 1) {
            return s;
        }

        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int left = 0;
        int right = 0;

        for (int i = len - 1; i >= 0; i--) {
            // 将对角线（即i==j的情况）赋值为true
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {

                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && right - left < j - i) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left, right + 1);
    }
}
