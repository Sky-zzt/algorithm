package arrary;

public class sortLetters {

    public static void main(String[] args) {
        sortLetters(new char[]{'a','b','C','U','s','K'});

    }
//就是利用 如过两个while  都出来了 那说明 可定是遇到了 大小写  下面 我给他们互换一下
    public static void sortLetters(char[] chars) {
        // write your code here
        int i = 0, j = chars.length - 1;

        while (i <= j) {
            while (i <= j && Character.isLowerCase(chars[i])) {
                i++;
            }
            while (i <= j && Character.isUpperCase(chars[j])) {
                j--;
            }
            if (i <= j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;
                i++;
                j--;
            }
        }
    }
}
