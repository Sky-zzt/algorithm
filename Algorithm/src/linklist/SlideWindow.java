package linklist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlideWindow {

/*
生成窗口内最大值数组  进阶2
1：39
 */

    public static int[] getmaxwindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();//双向队列
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();//加数

            }
            qmax.add(i);
            //减数的逻辑  很简单:就是当前面哪个指针走的步数已经大于k了，为了维持窗口不变
            //那么后面哪个指针应该往上走，但是，后面指针的后面那部分的最大值还放在
            //队列里 必须删掉
            if (qmax.peekFirst() == i - w) {  //i-w时减数  画一下就知道了
                qmax.pollFirst();
            }
            if (i >= w - 1) {  //因为你至少要进去三个数才能有最大值   i=2 是  形成了第一个窗口  以后都有窗口
                res[index++] = arr[qmax.peekFirst()];//当前的最大数放大数组里
            }
        }
        return res;
    }

    /*
    //双向队列
  头 大      小 尾
     */
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k < 0) {
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //queue.add(i);
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.add(i);

            if (i - queue.peekFirst() == k) {
                queue.pollFirst();
            }
            if (i >= k - 1) {
                res.add(nums[queue.peekFirst()]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 7, 7, 8};
        //   List<Integer> list = maxSlidingWindow(ints, 3);
        // list.forEach(aa -> System.out.println(aa));
    }
}
