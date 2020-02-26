package designStyle;

public class Singleten1 {
    private int age;
    private String name;
  private static Singleten1 singleten = new Singleten1();
 private Singleten1(){

 }
    public static Singleten1 getInstance(){
        return singleten;
    }

    public static void main(String[] args) {
        System.out.println(Singleten1.getInstance());
        System.out.println(Singleten1.getInstance());
        System.out.println(new Singleten1());
    }
}
