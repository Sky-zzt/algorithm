package stringopreation;

import java.security.PublicKey;

public class replaceSpace {
    /*
    题目描述
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
     */
    public static String replaceSpace(StringBuffer str) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");

            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("We Are Happy");
        char[] chars = {'q', '2', 'e'};
        buffer.append(chars,0,2);
    //    buffer.append("sss",0,3);
        System.out.println(buffer.toString());
//        String s = replaceSpace(buffer);
//        System.out.println(s);

    }
}
