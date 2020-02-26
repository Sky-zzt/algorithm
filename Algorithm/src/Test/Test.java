package Test;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.PriorityQueue;

import static java.lang.System.*;

public class Test {
    static int i = 0;
   static volatile boolean run = true;
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
//      st

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (run) {
                    i++;
                    out.println();
                }
            }
        }).start();
        Thread.sleep(10000);
        run = false;
       // class .

    }
}
