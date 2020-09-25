package newcodebasic.basic;

import java.util.Arrays;

public class Code_03_HeapSort {
/*
heap就是完全二叉树
大根堆 就是头节点是最大的  任何一个子树的最大值都是他的头部
 */
	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		int size = arr.length;
		//swap(arr, 0, --size);
		while (size > 0) {
			swap(arr, 0, --size);
			heapify(arr, 0, size);

		}
	}
/*
用数组面试堆  2*i+1 左孩子  2*i+2  右孩子  父节点 i-1/2   i是数组下标
变成大根堆就是没到数组的一个位置  就把这部分变成大根堆
 */
	public static void heapInsert(int[] arr, int index) {//形成大根堆  和14行连起来
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;//一直找他他的赴 直到满足条件
		}
	}
/*
核心思想就是和自己的两个孩子比较
往下沉
 *///index位置的值变小了  然后怎们调整成一个堆
	public static void heapify(int[] arr, int index, int size) {//假设数组中有一个属变化了  重新调整为大根堆 size《=arr。len
		int left = index * 2 + 1;
		while (left < size) {
			//index 变小了
			//我左孩子 和有孩子 谁大  谁的下标就是largst
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
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
//			heapSort(arr1);
//			comparator(arr2);
//			if (!isEqual(arr1, arr2)) {
//				succeed = false;
//				break;
//			}
//		}
//		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//		int[] arr = generateRandomArray(maxSize, maxValue);
//		printArray(arr);
//		heapSort(arr);
//		printArray(arr);
		int[] ints = {4, 1, 11, 6, 2};
		System.out.println(-1/2);
		//heapSort(ints);
		for (int i = 0; i <ints.length ; i++) {
			heapInsert(ints,i);
		}
		System.out.println(Arrays.toString(ints));
		//System.out.println();
		//ClassLoader classloader = Load2.class.getClassLoader();
	}

}
