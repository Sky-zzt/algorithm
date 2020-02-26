package Test;

import java.net.SocketAddress;
import java.util.HashMap;

public class Maintestargs <k>{

    private HashMap<k,Integer> keyindexmap;
    private HashMap<Integer,k> valueindexmap;
    private int size;

    public Maintestargs() {
        this.keyindexmap = new HashMap<k, Integer>();
        this.valueindexmap = new HashMap<Integer, k>();
        this.size = 0;
    }
    public void insert(k key){
        if (!this.keyindexmap.containsKey(key)){
           this.keyindexmap.put(key,size);
            this.valueindexmap.put(size++,key);

        }




    }
    public void  delete(k key){
        if (!keyindexmap.containsKey(key)){
            return;
        }

        Integer integer = keyindexmap.get(key);
     //   keyindexmap.remove(key);
        k k = valueindexmap.get(size-1);  //size是5  从0开始  谢谢
        valueindexmap.put(integer,k);
        valueindexmap.remove(size-1);
size--;
    }
    public k getrondm(){
        if (size==0){
            return null;
        }
        return valueindexmap.get((int )(Math.random()*size));

    }

    public static void main(String[] args) {
//        Maintestargs<String> stringMaintestargs = new Maintestargs<>();
//        stringMaintestargs.insert("sad");
//        stringMaintestargs.insert("sad");
//        stringMaintestargs.insert("sad1");
//        stringMaintestargs.insert("sad12");
//        stringMaintestargs.insert("sad124");
//        stringMaintestargs.insert("sad1245");
//        stringMaintestargs.delete("sad");
//        stringMaintestargs.delete("sad1");
//        stringMaintestargs.delete("sad12");
//        System.out.println(stringMaintestargs.getrondm());
//        System.out.println(stringMaintestargs.getrondm());
//        System.out.println(stringMaintestargs.getrondm());
//        System.out.println(stringMaintestargs.getrondm());
//        System.out.println(stringMaintestargs.getrondm());
//        System.out.println(stringMaintestargs.getrondm());
//        System.out.println(stringMaintestargs.getrondm());

    }



    }

