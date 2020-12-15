package com.maowudi.huaweiod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 题目描述
 * 给定n个字符串，请对n个字符串按照字典序排列。
 * 输入描述:
 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述:
 * 数据输出n行，输出结果为按照字典序排列的字符串。
 */
public class NewCoder14 {

    public static void main(String[] args) throws IOException {
        //通过char大小比较
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        Integer n = Integer.parseInt(line);
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            String readLine = bufferedReader.readLine();
            list.add(readLine);
        }
        list.sort(null);
        list.stream().forEach(c-> System.out.println(c));
    }
}
