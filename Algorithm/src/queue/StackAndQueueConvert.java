package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackAndQueueConvert {   //最好写成类
    public static void main(String[] args) {
        Queue<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        int sqc = sqc(integers);
        System.out.println(sqc);

    }

    public static int sqc(Queue<Integer> integers) {
     //   Queue<Integer> integers = new LinkedList<>();
        Queue<Integer> integers1 = new LinkedList<>();
        int size = integers.size();
        while ((size)-- > 1) {  //可以直接把size--换成intergers。size（），这是动态变化的
            integers1.add(integers.poll());

        }
        Integer poll = integers.poll();
        Queue<Integer> tmp = integers;
        integers = integers1;
        integers1 = tmp;

        return poll;
    }

}
