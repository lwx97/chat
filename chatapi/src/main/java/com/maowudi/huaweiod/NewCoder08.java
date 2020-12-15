package com.maowudi.huaweiod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeMap;

/**
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 */
public class NewCoder08 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            Integer n = Integer.valueOf(str);
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i=0;i<n;i++){
                str = bufferedReader.readLine();
                String[] sArr = str.split(" ");
                if (map.containsKey(Integer.valueOf(sArr[0]))) {
                    map.put(Integer.valueOf(sArr[0]),map.get(Integer.valueOf(sArr[0]))+Integer.valueOf(sArr[1]));
                }else {
                    map.put(Integer.valueOf(sArr[0]),Integer.valueOf(sArr[1]));
                }
            }
            Set<Integer> integers = map.keySet();
            for (Integer key : integers) {
                System.out.println(key + " " + map.get(key));
            }
        }
    }
}
