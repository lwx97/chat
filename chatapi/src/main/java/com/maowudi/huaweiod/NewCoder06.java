package com.maowudi.huaweiod;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 */
public class NewCoder06 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int num = Integer.valueOf(bufferedReader.readLine());
        for (int i=2;i<=num;i++){
            if (num%i==0){
                stringBuilder.append(i).append(" ");
                num = num/i;
                i --;
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
