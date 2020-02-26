package binarysearch;

public class UglyNumber {
/*
设计一个算法，找出只含素因子2，3，5 的第 n 小的数。

符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...

bool isUgly(int num) {
        while(num>1){
            if(num % 2 == 0){
                num=num/2;
            }else if(num % 3 == 0){
                num=num/3;
            }else if(num % 5 == 0){
                num=num/5;
            }else{
                return false;
            }
        }
        return num==1;




 */
    public static boolean isUgly(int num){
        if (num==1){
            return true;
        }
       while (true){
           if (num==1){
               return true;
           }
           if (num%2==0){
              num= num/2;
           }else if (num%3==0){
               num=num/3;
           }else if (num%5==0){
               num=num/5;
           }else {
               return false;

           }
       }

    }
}
