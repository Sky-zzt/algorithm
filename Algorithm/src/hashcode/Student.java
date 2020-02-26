package hashcode;

public class Student {
   private int age;
    private int count;

    public Student(int age, int count) {
        this.age = age;
        this.count = count;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int hashcode(){
        return age;
    }

    public Student(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", count=" + count +
                '}';
    }
}
