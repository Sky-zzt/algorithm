package stringopreation;

public class KMP {
    public static void main(String[] args) {
        char [] ch=new char[]{'1','a','s','d','q','g'};
        char[] str = {'s','a','q','w', 'd'};
        int kmp = kmp(ch, str);
        System.out.println(kmp);

    }
    public static int kmp(char ch[],char str[]){
        if (ch==null||str==null){
            return -1;
        }
        int i=0;
        int j=0;
        int [] next =getnextarray(str);
        while (ch.length>i&&str.length>j){
            if (ch[i]==str[j]){
                i++;
                j++;
            }else if (next[j]==-1){
                i++;
            }else {
                j=next[j];
            }
        }


        return j==str.length?i-j:-1;
    }

    private static int[] getnextarray(char[] str) {
          if (str.length==1){
            return new int []{-1};
        }
        int [] next=new int [str.length];
        next[0]=-1;
        next[1]=0;
        int pos=2;
        int cn=0;
        while (pos<str.length){
            if (str[pos-1]==str[cn]){
                next[pos++]=++cn;
            }else if (cn>0){
                cn=next[cn];
            }else {
                next[pos++]=0;//java的优先级 先赋值在加加 ++i是先加加在执行程序
            }

        }
        return next;
    }
}
