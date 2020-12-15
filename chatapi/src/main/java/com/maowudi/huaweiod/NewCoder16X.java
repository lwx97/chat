package com.maowudi.huaweiod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 题目描述
 * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，下表就是一些主件与附件的例子：
 * 主件	附件
 * 电脑	打印机，扫描仪
 * 书柜	图书
 * 书桌	台灯，文具
 * 工作椅	无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。王强想买的东西很多，
 * 为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。
 * 他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
 *     设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
 * v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
 *     请你帮助王强设计一个满足要求的购物单。
 *
 *
 *
 *
 * 输入描述:
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 *
 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 *
 *
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 *
 *
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 *
 *
 *
 *
 * 输出描述:
 *  输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 */
public class NewCoder16X {
    public static void main(String[] args) throws IOException {
        //1.金额之和不得超过n  m为行数
        //2.设total 为花费金额, num 为总计值 ,maxNum 为最大总计值
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = bufferedReader.readLine();
        String[] s = readLine.split(" ");
        int n = Integer.valueOf(s[0]);
        int m = Integer.valueOf(s[1]);
        int maxNum = 0;
        ArrayList<String> list = new ArrayList<>();
        for (int i=0;i<m;i++) {
            list.add(bufferedReader.readLine());
        }
        for (int i=0;i<m;i++) {
            int total = 0;
            int num = 0;
            ArrayList<Integer> arr = new ArrayList<>();//已购集合
            for(int k=i;k<m;k++) {
                for (int j=0;j<m;j++) {
                    if (j==k && k!=0) {
                        continue;
                    }
                    Integer v = Integer.valueOf(String.valueOf(list.get(j).split(" ")[0]));//价格
                    Integer p = Integer.valueOf(String.valueOf(list.get(j).split(" ")[1]));//重要度
                    Integer q = Integer.valueOf(String.valueOf(list.get(j).split(" ")[2]));//编号
                    if (q==0 || arr.contains(q)){
                        if (total + v > n){
                            continue;
                        }else{
                            total += v;
                            num += v*p;
                            arr.add(i+1);
                        }
                    }
                }
                if(num>maxNum) {
                    maxNum = num;
                }
            }

        }
        System.out.println(maxNum);
    }






















    private static int test(int j,ArrayList<String> list,int n){
        int total = 0;
        int num = 0;
        ArrayList<Integer> arr = new ArrayList<>();//已购集合
        for (int i = 0;i<list.size();i++) {
            for(int k = 0;k<list.size();k++) {
                int e = Integer.valueOf(String.valueOf(list.get(i).split(" ")[2]));
                if (e==0 || arr.contains(e)) {//附件只能主件购买后才能买
                    int c = Integer.valueOf(String.valueOf(list.get(i).split(" ")[0]));
                    int d = Integer.valueOf(String.valueOf(list.get(i).split(" ")[1]));
                    if (total + c > n){
                        continue;
                    }else{
                        total += c;
                        num += c*d;
                        arr.add(i+1);
                    }
                }
            }
        }
        return num;
    }
}
