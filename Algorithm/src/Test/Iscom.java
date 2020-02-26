package Test;

public class Iscom {
    public static void main(String[] args) {

        System.out.println(f(new double []{0,0},new double []{1,0},new double []{2.00001,0}));

    }
    public static boolean f(double A[],double B[],double C[]){
        if (A[0]-B[0]==0) return A[0]==C[0];
        return ((A[1]-B[1])/(A[0]-B[0]))== ((A[1]-C[1])/(A[0]-C[0]));

    }
}
