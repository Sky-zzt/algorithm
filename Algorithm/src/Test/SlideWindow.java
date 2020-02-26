package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SlideWindow {
    public static void main(String[] args) {


    }
    public static List<Integer> SlideWind(int nums[],int k){
        if (nums==null||nums.length==0){
            return new ArrayList<>();
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list!=null&&nums[list.peekLast()]<=nums[i]){
                list.removeLast();
            }
            list.offer(i);
            if (list.peekFirst()==i-k){
                list.removeFirst();
            }
            if (i>=k){
                list1.add(nums[list.peekFirst()]);

            }
        }
        return list1;
    }
}
