package stringopreation;

public class SimpleStringMatch {
    public static void main(String[] args) {
        char [] ch=new char[]{'1','a','s','d','q','g'};
        char[] str = {'s','w', 'd'};
        int simplematch = simplematch(ch, 0, str);
        System.out.println(simplematch);

    }
    public static int  simplematch(char ch[],int pos,char str[]){//简单的模式串匹配
        int i=pos;
        int j=0;
        while (i<ch.length&&j<str.length){
            if (ch[i]==str[j]){
                i++;
                j++;
            }else {  //回溯
                i=i-j+1;//不能i++，主串为起始位置的下一个 模式串从头开始
                j=0;
            }
        }

        if (j>=str.length){
            return (i-j);                 //模式串全部比完
        }else {
            return -1;
        }                       //return j>str.length?i-j:-1;

    }
}
