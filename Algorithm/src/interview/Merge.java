package interview;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.HashSet;

public class Merge {
    public static int All_Alias = 7;
    public static int NAME = 2;
    public static int SOURCE = 1;
    public static int CODE = 1;

    public static void mergeInfo2SameRows(int row1, int row2, String[] info) {
        if (row1 > row2 || info == null) {
            return;
        }

        String str1 = info[row1];
        String str2 = info[row2];
        String[] split1 = str1.split(",");
        String[] split2 = str2.split(",");
        if ("SOURCE".equals(split1[1]) || "SOURCE".equals(split1[1])) {
            return;
        }

        String[] split1_7 = null;
        String[] split2_7 = null;
        if (split1.length > 7) {
            split1_7 = split1[7].split("###");
        }
        if (split2.length > 7) {
            split2_7 = split2[7].split("###");
        }
        HashSet<String> set = new HashSet<>();
        set.add(split1[2]);
        set.add(split2[2]);
        for (int i = 0; i < split2_7.length; i++) {
            set.add(split2_7[i]);
        }
        for (int i = 0; i < split1_7.length; i++) {
            set.add(split1_7[i]);
        }
        String tmp = "";
        for (String s2 : set) {
            tmp += s2 + "###";
        }
        split1[7] = tmp;
        split1[7] = split1[7].substring(0, split1[7].length() - 3);

        String[] split1_6 = null;
        String[] split2_6 = null;
        if (split1.length > 7) {
            split1_6 = split1[6].split("###");
        }
        if (split2.length > 7) {
            split2_6 = split2[6].split("###");
        }
        HashSet<String> set1 = new HashSet<>();
        for (int i = 0; i < split1_6.length; i++) {
            set1.add(split1_6[i]);
        }
        for (int i = 0; i < split2_6.length; i++) {

            set1.add(split2_6[i]);
        }
        tmp = "";
        for (String s2 : set1) {
            tmp += s2 + "###";
        }
        split1[6] = tmp;
        split1[6] = split1[6].substring(0, split1[6].length() - 3);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("卫计委", 7);
        map.put("MOH", 6);
        map.put("CPA", 5);
        map.put("MERCK", 3);
        map.put("MUNDI", 4);
        map.put("PFIZER", 1);
        map.put("挂号", 2);
        map.put("Haodf", 0);

        if (split1.length > 1 && split2.length > 1) {
            if (map.containsKey(split1[1]) && map.containsKey(split2[1]) && map.get(split1[1]) < map.get(split2[1])) {
                split1[1] = split2[1];
            }
        }

        tmp = "";
        for (int i = 0; i < split1.length; i++) {
            tmp += split1[i] + ",";
        }

        info[row1] = tmp;
        info[row2] = tmp;
    }
}
