package tree.trie;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicography {

	/*
	把字符串数组以最小的字典序拼接起来   贪心策略
	 */

	public static class MyComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			return (a + b).compareTo(b + a);  //ab和ba拼接后的字典序大的大小
		}
	}

	public static String lowestString(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}

		Arrays.sort(strs, new MyComparator());
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			res += strs[i];
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
		System.out.println(lowestString(strs1));

		String[] strs2 = { "ba", "b" };
		System.out.println(lowestString(strs2));

	}

}
