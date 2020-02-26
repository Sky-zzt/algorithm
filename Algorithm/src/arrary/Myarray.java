package arrary;

public class Myarray {

    private int[] elements;

    public int size() {
        int length = elements.length;
        return length;

    }

    public Myarray() {
        elements = new int[0];
    }

    public void add(int a) {
        int[] newarr = new int[elements.length + 1];
        int i;
        for (i = 0; i < elements.length; i++) {
            newarr[i] = elements[i];

        }
        newarr[elements.length] = a;
        elements = newarr;
    }

    public void del(int index) {

        if (index < 0 || index > elements.length - 1) {

            throw new RuntimeException("yuejie");
        }
    }

    public void insert(int index, int a) {
        int[] newarr = new int[elements.length + 1];
        int i = 0;
        for (i = 0; i < elements.length; i++) {
            if (i < index) {
                newarr[i] = elements[i];
            } else {
                newarr[i + 1] = elements[i];
            }

        }
        newarr[index] =a;
        elements = newarr;
    }

    public static void main(String[] args) {

        Myarray myarray = new Myarray();
        myarray.add(10);
        myarray.add(100);
        myarray.add(100);
        myarray.add(1000);
        myarray.add(1000);
        myarray.add(1000);
        myarray.add(1000);
        myarray.add(1000);
        myarray.insert(8, 15445);
        for (int i = 0; i < myarray.size(); i++) {
            System.out.println(myarray.elements[i]);


        }

    }
}
