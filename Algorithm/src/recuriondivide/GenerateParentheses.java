package recuriondivide;

import java.util.ArrayList;

public class GenerateParentheses {
    public static void main(String[] args) {
      ArrayList<String> list = new ArrayList<>();
//        parentheses("",3,list);
//        System.out.println(list);
      parentheses1("",3,3,list);
        System.out.println(list);

    }
    public static void parentheses(String item, int n, ArrayList<String> result){
        if (item.length()==2*n){
            result.add(item);
            return;
        }
        parentheses(item+'(',n,result);
        parentheses(item+')',n,result);

    }


      public static  void parentheses1(String item,int left,int right, ArrayList<String> result) {
       if (left==0&&right==0){
           result.add(item);
       }
       if (left>0){
           parentheses1(item+'(',left-1,right,result);
       }
       if (left<right){
           parentheses1(item+')',left,right-1,result);
       }
      }

  }

