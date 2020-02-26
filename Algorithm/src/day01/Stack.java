package day01;

import java.lang.reflect.Array;

public class Stack {
    int [] elements;

    public Stack() {
        elements=new int[10];

    }

    public void push(int a) {
        int[] newarr = new int[elements.length+1];
        int i;
        for (i = 0; i < elements.length; i++) {
            newarr[i] = elements[i];

        }
        newarr[elements.length] = a;
        elements = newarr;
    }
    public int  pou(){
        if(elements.length==0){
            throw new RuntimeException("heheh");
        }
        int element = elements[elements.length-1];
        int [] arr=new int[elements.length-1];
        for (int i = 0; i <elements.length-1 ; i++) {
            arr[i]=elements[i];
        }
elements=arr;
        return element;
    }
    public int  peek(){

        return  elements[elements.length-1];
    }


    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(4);
        stack.push(42);
        stack.push(43);
        stack.push(44);
        stack.push(45);
        int pou = stack.pou();
        int pou1 = stack.pou();
      //  int pou3 = stack.pou();
        int peek = stack.peek();
        System.out.println(peek);
    }


}
