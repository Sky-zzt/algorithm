package hashcode;

public class Testhashtable {
    public static void main(String[] args) {
        Student student1 = new Student(16, 3);
        Student student2 = new Student(17, 11);
        Student student3 = new Student(18, 23);
        Student student4 = new Student(19, 24);
        Student student5 = new Student(20, 9);
        Hashtable hashtable = new Hashtable();
        hashtable.add(student1);
        hashtable.add(student2);
        hashtable.add(student3);
        hashtable.add(student4);
        hashtable.add(student5);
        Student student = new Student(18);
        Student student6 = hashtable.get(student);
        System.out.println(student6);
    }
}
