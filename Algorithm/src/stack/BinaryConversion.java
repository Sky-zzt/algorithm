package stack;

import java.util.Stack;

public class BinaryConversion {
    public static void main(String[] args) {
        Stack stack = conversion(2013, 5);

        while (!stack.empty()) {
            System.out.println(stack.pop());

        }
        }
    public static Stack conversion(int num,int n){
        Stack<Integer> objects = new Stack<>();
       // char digit[]=new char[]{'0','1','2','3',....'F'};
        while (num>0){
            int yu=num%n;
            num=num/n;
        objects.push(yu);//push(digit[num%n])


    }

        return objects;
    }
}
