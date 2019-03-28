package com.test;

/**
 * Created by liusong on 2018/7/11.
 */
public class RandomTest {

    public static void main(String[] args) {
        int[] ints = new int[]{80, 650, 900, 500, 520, 600, 300, 440, 680};
        int result = 1340;
        for (int i = 0; i < ints.length; i++) {
            System.out.println(result - ints[i]);
        }
    }
}
