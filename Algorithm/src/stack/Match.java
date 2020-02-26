package stack;

import java.util.Stack;

public class Match {
    public static void main(String[] args) {
//括号匹配问题  栈的应用

        Stack stack = new Stack();
        char str[]={'(','[','{','}',']',')'};
        for (int j = 0; j <str.length ; j++) {
            switch (str[j]){

                case '(':
                case '[':
                case '{':
                    stack.push(str[j]);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()){
                        System.out.println("右括号多余");
                    }else {
                        if ((Object) str[j]==stack.peek()){//匹配函数需要自己写
                            stack.pop();
                        }else {
                            System.out.println("左右括号不同类");
                        }
                    }

            }
            if (stack.isEmpty()){
                System.out.println("match");
            }

        }



    }
}
