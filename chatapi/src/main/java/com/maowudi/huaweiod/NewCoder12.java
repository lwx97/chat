package com.maowudi.huaweiod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 *
 * 输入描述:
 * 输入一行，为一个只包含小写字母的字符串。
 *
 * 输出描述:
 * 输出该字符串反转后的字符串。
 */
public class NewCoder12 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        for (int i=line.length()-1;i>=0;i--){
            System.out.print(line.charAt(i));
        }
    }
}
