package interview;


import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ServiceConfigurationError;

public class ReadWriteAndCore {
    public static ArrayList<ArrayList<String>> nameGruop = null;

    public static String[] info = null;

    public static void main(String[] args) throws IOException {
        //读取数据放入list
        long millis = System.currentTimeMillis();
        File file = new File("C:\\Users\\zzt\\Documents\\WeChat Files\\zzt314884819\\FileStorage\\File\\2019-11\\test\\test.csv");
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        ArrayList<String> list = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(file));
            java.lang.String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                list.add(tempStr);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-millis);
        //把list放入string[]数组
        info = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            info[i] = list.get(i);
        }
        nameGruop = new ArrayList<>();
        //拆解每条信息的 变成名字组
        for (int i = 0; i < info.length; i++) {
            ArrayList<String> names = new ArrayList<>();
            String[] split = info[i].split(",");
            String[] split1 = split[7].split("###");
            for (int j = 0; j < split1.length; j++) {
                names.add(split1[j]);
            }
            names.add(split[2]);
            nameGruop.add(names);
        }
        //循环比对 虽然4个for 但只有 n2 复杂度
        boolean flag = false;
        long a = System.currentTimeMillis();
        for (int i = 0; i < nameGruop.size(); i++) {
            ArrayList<String> list1 = nameGruop.get(i);
            for (int j = 0; j < nameGruop.size(); j++) {
                if (i == j) {
                    continue;
                }
                ArrayList<String> list2 = nameGruop.get(j);
                flag = false;
                for (int k = 0; k < list1.size(); k++) {
                    if (flag) {
                        break;
                    }
                    for (int l = 0; l < list2.size(); l++) {
                        if (list1.get(k).equals(list2.get(l))) {
                            flag = true;
                            //合并去重
                            Merge.mergeInfo2SameRows(i, j, info);
                            break;
                        }
                    }
                }
            }
        }
        long a1 = System.currentTimeMillis();
        System.out.println(a1-a);
        long l = System.currentTimeMillis();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < info.length; i++) {
            set.add(info[i]);
        }
        FileWriter fw = new FileWriter("C:\\Users\\zzt\\Desktop\\a.csv");
        for (String s : set) {
            fw.write(s + "\n");
        }
        fw.close();
        long l3 = System.currentTimeMillis();
        System.out.println(l3-l);
        System.out.println(l3-millis);

    }
}
