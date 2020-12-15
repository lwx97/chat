package com.maowudi.huaweiod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewCoder04 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine())!=null) {
            str0(str);
        }
    }


    private static void str0(String str){
        if (!"".equals(str)) {
            if (str.length()<8) {
                int len = str.length();
                for (int i=0;i<8 - len ;i++) {
                    str = str + "0";
                }
                System.out.println(str);
            } else {
                System.out.println(str.substring(0,8));
                str0(str.substring(8));
            }
        }
    }
}
