package recuriondivide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RecurionRecallsubset {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
      // int[] subset = subset(arr);
        ArrayList<ArrayList> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
subsetrecurion(arr,0,list,result);

    }

    public static int[] subset(int[] arr) {
        ArrayList<ArrayList> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            //传入的始终是list这个集合的引用 是地址

            result.add(list);//传回去只能是123456
            System.out.println(result);

        }
        return null;

    }

    public static void subsetrecurion(int arr[], int i, ArrayList arrayList, ArrayList arrayList1) {
        ArrayList<ArrayList> result = new ArrayList<>();
        if (i >= arr.length) {
            return;

        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[i]);
        result.add(list);
        System.out.println(result);
        subsetrecurion(arr,i+1,list,result);

    }
}
