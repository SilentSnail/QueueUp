package com.test;

/**
 * Created by liusong on 2018/7/11.
 */
public class RandomTest {

    public static void main(String[] args) {
        System.out.println(String.valueOf(-13) + " -- " + String.valueOf(Integer.toBinaryString(-13)));
        System.out.println(String.valueOf(-13 >> 1) + " -- " + String.valueOf(Integer.toBinaryString(-13 >> 1)));
        System.out.println(String.valueOf(-13 >> 2) + " -- " + String.valueOf(Integer.toBinaryString(-13 >> 2)));
        System.out.println(String.valueOf(-13 >> 3) + " -- " + String.valueOf(Integer.toBinaryString(-13 >> 3)));
        System.out.println(String.valueOf(-13 >> 4) + " -- " + String.valueOf(Integer.toBinaryString(-13 >> 4)));
        System.out.println(String.valueOf(-13 >> 5) + " -- " + String.valueOf(Integer.toBinaryString(-13 >> 5)));
    }
}
