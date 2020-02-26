package MAP;

import java.util.HashMap;
import java.util.Scanner;
//计算每个字符串中字符的出现子树
public class AppearnumInString {
    public static void main(String[] args) {
        System.out.println("请输入一个字符串：");
        String s = new Scanner(System.in).nextLine();
        appnum(s);

    }

    public static void appnum(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int j=1;
        for (int i=0;i<chars.length;i++){
            if (!map.containsKey(chars[i])){  //不包含就加进来  包含就看他出现的次数  然后在继续++
                map.put(chars[i],1);
            }else {

                int cout=map.get(chars[i]);
                map.put(chars[i],++cout);
            }

        }
        System.out.println(map);

    }
}
