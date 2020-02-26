package Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class decode {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String keyWord = URLDecoder.decode("%E5%85%89%E9%98%B4", "UTF-8");
        System.out.println(keyWord);
    }
}
