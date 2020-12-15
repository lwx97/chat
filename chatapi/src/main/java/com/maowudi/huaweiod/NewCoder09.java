package com.maowudi.huaweiod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 */
public class NewCoder09 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        char[] chars = str.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=chars.length-1;i>=0;i--) {
            Integer in = Integer.valueOf(chars[i] + "");
            if (list.size()==0 && in == 0){
                continue;
            }
            if (!list.contains(in)) {
                list.add(in);
            }
        }
        list.stream().forEach(c -> System.out.print(c));
    }
}
