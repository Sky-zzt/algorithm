package interview;

import java.util.StringTokenizer;

public class test {

    public static final int All_Alias = 7;
    public static final int NAME = 2;

    public static void main(String[] args) {

        String s = "GID40532,PFIZER,龚路镇地段医院,1,上海市,上海市,HO00027394,龚路镇地段医院###龚路医院,上海市黄浦区地段医院,上海市,上海市,121.471291,31.23679,兴趣点,wtw3snkxqpxq,121.468816076,31.2572897993,精确查找,医疗,wtw3u44yut1u,HO00027394";
        String[] split = s.split(",");

      //  StringBuilder stringBuilder = new StringBuilder(split);
        //  StringBuffer split2 = (StringBuffer) split;


        String[] split1 = split[All_Alias].split("###");

        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < split1.length; j++) {
                if (split[i]==split1[j]){
                    return;
            }
        }


       StringBuffer buffer = new StringBuffer();
            buffer.append("dsdsfd");
            buffer.append("hello");
            String s1 = buffer.toString();
            System.out.println(s1);
            //  buffer.append(split[NAME]);
//        for (int i = 0; i < split1.length; i++) {
//       //     buffer.append(split1[i]);
//        }
       // String s1 = buffer.toString();
   //     for (int i = 0; i < s1.length(); i++) {
          //  System.out.print();
            System.out.println();
        }

    // split+=split1;
//        for (String s1 : split1) {
//            System.out.println(s1);
//        }

    }
}
