package Test;

public class clock {
    public static void main(String[] args) {
     angle(12, 15);
    }

    public static void angle(int hour, int min) {
        double ang1 = 0;
        double ang = 0;
      if ((0 <= hour&&hour <= 12) && (0 <= min&&min <= 60) ){

            for (int i = 0; i < hour; i++) {
                ang = hour * Math.PI / 6;
            }

            for (int i = 0; i < min; i++) {
                ang1 = min * Math.PI / 60;
            }
            ang = ang + ang1 / 12;

          System.out.println(Math.cos(Math.abs(ang - ang1)));
        }
      else {
          System.out.println("输入有误");
      }

        // return Math.abs(ang-ang1);
    }
}
