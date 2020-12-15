package com.maowudi.huaweiod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 */
public class NewCoder03 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int[] ints;
        while ((str = reader.readLine()) != null && !"".equals(str)){
            int n = Integer.valueOf(str);
            ints = new int[n];
            for (int i=0;i<n;i++) {
                ints[i] = Integer.parseInt(reader.readLine());
            }
            quchong(ints);
        }
    }


    private static void quchong(int[] arr) {
        //通过set集合去重机制
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr) {
            set.add(i);
        }
        Object[] objects = set.toArray();
        Arrays.sort(objects);
        for (Object i : objects) {
            System.out.println(i);
        }
    }
}
