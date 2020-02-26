package MAP;

import java.util.HashMap;

public class Map {
    public static void main(String[] args) {
        //求一个数组中出现次数大于n/2的数，这个数组一定会有这个数
        int[] arr = {1, 3, 3, 6, 3, 3};
        MajorityElement(arr);

    }
    /*

    可以用map   判断相不相交 以及有无环都可用map
    判断最后一个节点是否相等  否 无环
    知道lenth  loop 即入环节点
    有环 无环不能相交
    都有环有三种情况i昂  不相交  和两种相交

     */

    public static void MajorityElement(int arr[]) {


        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int len = arr.length;
        for (Integer num : arr) {
            Integer count = hashMap.get(num);
            if (count == null) {
                hashMap.put(num, 1);

            } else {
                hashMap.put(num, hashMap.get(num) + 1);

            }
            if (hashMap.get(num) > (len / 2)) {

                System.out.println(num);
            }


        }
    }


}


