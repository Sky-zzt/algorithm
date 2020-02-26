package newcodebasic.basic;

public class Code_05_Manacher_ShortestEnd {

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static String shortestEnd(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length];
		int index = -1;
		int pR = -1;//回文最优边界
		int maxContainsEnd = -1;
		for (int i = 0; i != charArr.length; i++) {    //
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1; //parr是回文半径数组
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			if (pR == charArr.length) {
				maxContainsEnd = pArr[i];
				break;
			}
		}
		char[] res = new char[str.length() - maxContainsEnd + 1];
		for (int i = 0; i < res.length; i++) {
			res[res.length - 1 - i] = charArr[i * 2 + 1];
		}
		return String.valueOf(res);
	}

	public static void main(String[] args) {
		String str2 = "abcd123321";
		System.out.println(shortestEnd(str2));

	}

    public static class maxgap {
        /*
        给定一个数组，求如果排序之后，相邻两数的最大差值，要求时
    间复杂度O(N)，且要求不能用非基于比较的排序。
         */
        public static void main(String[] args) {
            int[] maxgap = maxgap(new int[]{-100,0,1,15,18,89, 100});
            for (int i : maxgap) {
                System.out.println(i);
            }

        }
        public static int[] maxgap(int arr[]){
            int N = arr.length;
            int[] max = new int[N+1];
            int[] min = new int[N+1];
            boolean[] booleans = new boolean[N+1];
            for (int i = 0; i <N ; i++) {
                int bucket = Code_11_MaxGap.bucket(arr[i],N,arr[0],arr[N-1]);
                if (booleans[i]==false){
                    min[i]=max[i]=arr[i];
                    booleans[i]=true;
                }else if (bucket>max[i]){
                    max[i]=bucket;
                }else if (bucket<min[i]){
                    min[i]=bucket;
                }
            }
            int[] maxgap = new int[N+1];
            for (int i = 1; i <N ; i++) {
                if (booleans[i]) {
                    maxgap[i] = max[i] - min[i - 1];
                }else {
                    maxgap[i] = max[i+1] - min[i - 1];
                }
            }
    return maxgap;

        }






    }
}
