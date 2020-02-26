package daypractice;

public class ZUHE {
    public static void main(String[] args) {
        int sum=0;
        int[] ints = {1, 2, 3, 8, 5};
        for (int i = 0; i <ints.length ; i++) {
            for(int j=i+1;j<ints.length;j++){

                for(int k=j+1;k<ints.length;k++){
                    sum=ints[i]+ints[k]+ints[j];
                   if(sum==10||sum==20||sum==30){
                       System.out.println(ints[i]+" "+ints[j]+" "+ints[k]);

                   }
                }
            }

        }
    }
}
