package greedy;

import java.util.Arrays;
import java.util.Collections;

public class AssignCookies {
    public static void main(String[] args) {
        System.out.println(assigncookies(new int[]{5,10,2,9,15,9},new int[]{6,1,20,3,8}));

    }
    public static int assigncookies(int need[],int sandy[]){
        int child=0;

        Arrays.sort(need);
        Arrays.sort(sandy);
        int i=0;
        int j=0;
        while (i<need.length&&j<=sandy.length){

            if (need[i]<sandy[j]){
                i++;
                j++;
                child++;
            }else {

                j++;
            }
        }
return child;
    }
}
