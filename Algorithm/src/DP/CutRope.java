package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class CutRope {

    /*
    给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
    每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
    例如，当绳子的长度是8时，
    我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

    怎们定义状态函数是个技术活
    定义 ： f【n】是长度为n绳子的最大乘积
    那么他就应该等于如下：
    发f[n]=maxf[n-i]*f[i]  遍历i
    这道题目的临界点其实是4，也就是说4以下的其实不论怎么分，成绩都不可能比自身的数大！那么此时存储的其实是最大的值，不一定是乘法最大值，额
     */
    public static void main(String[] args) {
        cutrope(8);

    }
    public static int cutrope(int target){


        int[] f = new int[target+1];
   //     new ArrayList<Integer>();
        f[0]=1;
        f[1]=1;
        f[2]=2;
        f[3]=3;

int max=0;
        for (int i = 4 ; i <= target; i++) {
            for (int j = 1; j <i ; j++) {
                f[i]=f[i-j]*f[j];
                if (f[i]>max){
                    max=f[i];
                }
                f[i]=max;
                System.out.println(f[i]);
            }

        }

        Arrays.sort(f);
        System.out.println(f[target]);
        System.out.println(f[0]);
        return f[target];

    }
}
