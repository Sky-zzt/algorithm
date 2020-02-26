package depthsearch;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
/*
给定字符串 s, 需要将它分割成一些子串, 使得每个子串都是回文串.

返回所有可能的分割方案.

输入: "aab"
输出: [["aa", "b"], ["a", "a", "b"]]
解释: 有两种分割的方式.
    1. 将 "aab" 分割成 "aa" 和 "b", 它们都是回文的.
    2. 将 "aab" 分割成 "a", "a" 和 "b", 它们全都是回文的.
Notice
不同的方案之间的顺序可以是任意的.
一种分割方案中的每个子串都必须是 s 中连续的一段.
 */

    public List<List<String>> substring(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }

        List<String> partition = new ArrayList<String>();
        helper(s, 0, partition, results);

        return results;

    }

    private void helper(String s,
                        int index,
                        List<String> substring,
                        List<List<String>> results) {

        if (index==s.length()){
            results.add(new ArrayList<String>(substring));
        }


        for (int i = index; i < s.length(); i++) {  //n个字符串 n-1个切割位置
            String subString = s.substring(index, i + 1); //index  从哪个位置开始切割
            if (!isPalindrome(subString)){
                continue;
            }
            substring.add(subString);
            helper(s,i+1,substring,results);
            substring.remove(substring.size()-1);

        }

    }

    public static void main(String[] args) {
        PalindromePartitioning partitioning = new PalindromePartitioning();
        String s="abc";
        System.out.println(partitioning.substring(s));
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
