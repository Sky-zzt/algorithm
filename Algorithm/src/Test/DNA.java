package Test;

import java.util.Scanner;

public class DNA {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String str = input.next();
            int n = input.nextInt();
            int max = 0;
            int maxBeginIndex = 0;
            for (int i = 0; i <= str.length() - n; i++) {
                int count = 0;
                for (int j = i; j < i + n; j++) {
                    if (str.charAt(j) == 'G' || str.charAt(j) == 'C') {
                        count++;
                    }
                }
                if (count > max) {
                    maxBeginIndex = i;
                    max = count;
                }
            }
            System.out.println(str.substring(maxBeginIndex, maxBeginIndex + n));
        }
    }


}
