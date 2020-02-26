package hashcode;

import org.jetbrains.annotations.NotNull;

public class Hashtable {
      private Student [] data =new Student[100];

      public static void add(@NotNull Student student){
          System.out.println("fdfd");
        int index=student.hashcode();
      //    data[index]=student;
      }
      public Student get(Student student){
          return data[student.hashcode()];
      }

    public static void main(String[] args) {

        Object o = new Object();
        o=null;
        o.toString();

    }
}
