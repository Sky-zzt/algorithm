package Test;

public class printmatrix {

    public static void main(String[] args) {
//print(new int[][]{{1,2,3,4},{4,8,5,6},{9,7,8,9},{19,10,11,23}},4,4);
        printmain(new int[][]{{1,2,3,4},{4,8,5,6}});

    }



    public static void printmain(int [][] arr){
        int rowlen = arr.length;
        int colen = arr[0].length;
   //   print(arr,rowlen,colen,0);
     //   print(arr,rowlen-1,colen-1);
        System.out.println("-----------------------");
    //    print(arr,rowlen,colen,1);

    }
    public static void print(int[][] m,int tR, int tC, int dR, int dC){

        while (tC<dC&&tR<dR){
            printEdge(m,tR++,tC++,dR--,dC--);


        }

    }
    public static void printEdge(int[][] m, int tR, int tC, int dR, int dC){
        if (dR==0){
            for (int i = 0; i < dC; i++) {
                System.out.println(m[dR][i]);
            }
            for (int i = 0; i < dC - 1; i++) {
                System.out.println(m[tR][i]);
            }


        }


    }
}
