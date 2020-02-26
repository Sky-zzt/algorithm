package Sort;

import java.util.Arrays;

public class MergeSort1 {
	 /*
    归并排序（MERGE-SORT）是建立在归并操作上的一种有效的排序算法,
    该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，
    得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
    若将两个有序表合并成一个有序表，称为二路归并
    将两个已排好序的数组合并成一个有序的数组,称之为归并排序
步骤：遍历两个数组，比较它们的值。谁比较小，谁先放入大数组中，直到数组遍历完成

外排序的方式
     */
	/**
	 merge局部有序到整体有序  稳定排序  时间复杂度nlogn 空间复杂度 N
	quicksort 整体有序 在局部有序 不稳定
	 **/

	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if (l < r) {
			int mid = l + ((r - l) >> 1);
			mergeSort(arr, l, mid);
			mergeSort(arr, mid + 1, r);
			merge(arr, l, mid, r);
		}

	}

	public static void merge(int[] arr, int l, int m, int r) {//外排
		//两个有序数组  外排合并 
		int[] help = new int[r - l + 1];
		int i = 0;
		int p1 = l; //不是p1=0
		int p2 = m + 1;
		while (p1 <= m && p2 <= r) {
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		//肯定会有且只能有一个越界
		while (p1 <= m) {//p1没越界 ，那么p2必越界，  此时吧p1拷贝到help数组
			help[i++] = arr[p1++];
		}
		while (p2 <= r) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {//覆盖arr
			arr[l + i] = help[i];  //不是arr[i]=help[];
		}
	}

	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
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

	// for test
	public static void main(String[] args) {
//		int testTime = 500000;
//		int maxSize = 100;
//		int maxValue = 100;
//		boolean succeed = true;
//		for (int i = 0; i < testTime; i++) {
//			int[] arr1 = generateRandomArray(maxSize, maxValue);
//			int[] arr2 = copyArray(arr1);
//			mergeSort(arr1);
//			comparator(arr2);
//			if (!isEqual(arr1, arr2)) {
//				succeed = false;
//				printArray(arr1);
//				printArray(arr2);
//				break;
//			}
//		}
		//System.out.println(succeed ? "Nice!" : "Fucking fucked!");

//		int[] arr = generateRandomArray(maxSize, maxValue);
//		printArray(arr);
//		mergeSort(arr);
//		printArray(arr);
		int[] ints = {1, 5, 12, 3, 6, 10, 34};
		System.out.println(ints);
		String s= "11";
		me(ints,0,2,ints.length-1,s);
		System.out.println(s);
		System.out.println(ints);
		for (int i = 0; i < ints.length; i++) {
			System.out.println(ints[i]);
		}

	}
public static 	int[] ints;
	public static void me(int [] arr,int start,int mid ,int end,String s){
//
		ints = new int[end - start + 1];
		int p1=start;
		int p2=mid;
		int p3=end;
		int i=0;

		while (p1<=mid&&p2<end){
			if (arr[p1]<=arr[p2]){
				ints[i++]=arr[p1++];

			}else {
				ints[i++]=arr[p2++];
			}

		}
//		System.out.println(arr);
//		System.out.println(ints);
	arr=ints;
		String ss="ssfdsf";
		s=ss;
		System.out.println(arr);
	}
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
}
