package Test;

import java.nio.charset.Charset;
import java.util.*;
import java.util.function.BiConsumer;

public class str
{
    public static void main(String[] args) {

//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("zzt",10);
//        map.put("zz1",10);
//        map.put("z1",10);
//        map.put("z1w",1);
//        map.put("z1wq",2);
//        map.put("z1e1",3);
//
//
//        ArrayList<HashMap<String,Integer>> list = new ArrayList<HashMap<String,Integer>>((Collection<? extends HashMap<String, Integer>>) map);
//        list.add(map);//你就list 添加了一个元素 排尼玛呢
//        list.sort((o1, o2) -> {
//            Set set = o1.keySet();
//            Set set1 = o2.keySet();
//            return o1.get(set) - o2.get(set1);
//
//        });
//        for (HashMap<String, Integer> hashMap : list) {
//            System.out.println(hashMap.values());  //[10, 1, 10, 10, 2, 3]
//        }


        Map<String, Integer> map1 = new HashMap<>();
        map1.put("王二", 8);
        map1.put("沈吴", 2);
        map1.put("小菜", 3);
        map1.put("大鸟", 1);
        map1.put("大泡", 8);

        Set<Map.Entry<String, Integer>> entrySet = map1.entrySet();
        for (Map.Entry s : entrySet)
        {
            System.out.println(s.getKey()+"--"+s.getValue());
        }

        System.out.println("============排序后============");

        //////借助list实现hashMap排序//////

        //注意 ArrayList<>() 括号里要传入map.entrySet()
        List<Map.Entry<String, Integer>> list1 = new ArrayList<>(map1.entrySet());
        Collections.sort(list1, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                //按照value值，重小到大排序
//                return o1.getValue() - o2.getValue();

                //按照value值，从大到小排序
//                return o2.getValue() - o1.getValue();

                //按照value值，用compareTo()方法默认是从小到大排序
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        //注意这里遍历的是list，也就是我们将map.Entry放进了list，排序后的集合
        for (Map.Entry s : list1)
        {
            System.out.println(s.getKey()+"--"+s.getValue());
        }


        char[] chars = {'a', ' ', 'b'};
        System.out.println(chars
        .toString());


    }
    public static void ha(int o){
        String s="";
        ArrayList<String> ss=new ArrayList<>();

        for (int i = 0; i <=10; i++) {
            ss.add("");
        }
        for (int i = 0; i <=o ; i++) {
            s=s+"*";
ss.toArray();
            System.out.println(ss+s);
           ss.remove(o-i);
        }

    }

}
