package com.maowudi.huaweiod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
 *
 * 输出描述:
 * 输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 */
public class NewCoder05 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            _16to10(str);
        }
    }

    /**
     * 16进制    当前位的值*16的当前位置的坐标-1次方  所有位相加
     */
    private static void _16to10(String str){
        if (!"".equals(str)){
            StringBuffer buffer = new StringBuffer(str);
            buffer.delete(0,2);
            int i = Integer.parseInt(buffer.toString(), 16);
            System.out.println(i);
        }
    }

}
