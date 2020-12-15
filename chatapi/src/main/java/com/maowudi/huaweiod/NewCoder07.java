package com.maowudi.huaweiod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 */
public class NewCoder07 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int i = str.lastIndexOf(".");
        if (i!=-1){
            char[] chars = str.toCharArray();
            System.out.println(Integer.valueOf(chars[i+1] + "") >= 5 ? Integer.valueOf(str.substring(0,i)) + 1 : Integer.valueOf(str.substring(0,i)));
        }
    }
}
