package newcodebasic.basic;

public class Code_08_NetherlandsFlag {
	/*
对于一个数组，当我们遇到一个等于num的数时，less不动，当前位置加加，
遇到一个比num小的让他和less的下一个交换less加加，当前位置加加。遇到一个大于num的
跟more的前一个交换，more--，换过来后在与这个num比 。同理的过程
0的左边是小于的区域  arr.length右边是大于得到区域 中间等于
 */
//荷兰国旗问题相当于三根指针 less more l  解决三分 即左中间右   而两根指针 只能分成两边 左右 无法处理等于traget的情况

	//可以解决范围更广的划分问题
	public static int[] partition(int[] arr, int l, int r, int p) {
		int less = l - 1;
		int more = r + 1;
		while (l < more) {
			if (arr[l] < p) {
				swap(arr, ++less, l++);
			} else if (arr[l] > p) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		return new int[] { less + 1, more - 1 }; //返回等于区域是哪个范围
	}
	//两根指针
	public static int[] partion(int[] arr, int target) {
		int begin = 0;
		int end = arr.length - 1;
		while (begin < end) {
			while (begin<end&&arr[begin]<target){
				begin++;
			}
			while (begin<end&&arr[end]>target){
				end--;
			}
			if (begin<=end){
				swap(arr,begin,end);
			}
		}
		return new int[]{begin,end};
	}


	// for test
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 1);
		printArray(test);
		System.out.println(res[0]);
		System.out.println(res[1]);


	}
}
