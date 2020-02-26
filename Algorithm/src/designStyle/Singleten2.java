package designStyle;

public class Singleten2 {
    public int age=100;
 public String name="zzt";
    public static Singleten2 s;
    private Singleten2(){

    }
    public static synchronized Singleten2 getIntance(){
        if (s==null){
            return new Singleten2();
        }
        return s;

    }
}
