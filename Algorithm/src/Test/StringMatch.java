package Test;

import java.sql.SQLOutput;

public class StringMatch {

    public static void main(String[] args) {
        System.out.println(strStr("1abcdeabe","abc"));
    }
    public static  int strStr(String source, String target) {
        // Write your code here
        if (source == "" && target == "") {
            return 0;
        }

        char[] sour = source.toCharArray();
        char[] tar = target.toCharArray();
        int m = sour.length;
        int n = tar.length;
        int i = 0, j = 0;
        int h=0;
        while (i < n && j < m) {
            if (sour[j] == tar[i]) {
                h++;
                i++;
                j++;
            } else {
                j=j-h+1;
                h=0;
                i = 0;
            }
            if (i == n ) {
                return j-i;
            }
        }
        return -1;
    }
}
