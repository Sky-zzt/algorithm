package Test;

import java.util.ArrayList;

public class subset {
    public static void main(String[] args) {


    }
    public static void generate(int i,int arr[], ArrayList list){
        if (i>=arr.length){
            return;
        }
        list.add(arr[i]);
        generate(i+1,arr,list);
        list.remove(i);
        generate(i+1,arr,list);


    }
}
