package com.maowudi.huaweiod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述:
 *  输入一个整数（int类型）
 *
 * 输出描述:
 *  这个数转换成2进制后，输出1的个数
 */
public class NewCoder15 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = bufferedReader.readLine();
        int i = Integer.parseInt(readLine);
        String str = Integer.toString(i, 2);
        int count = 0;
        for (int j=0;j<str.length();j++){
            if (str.charAt(j)=='1'){
                count++;
            }
        }
        System.out.println(count);
    }
}
