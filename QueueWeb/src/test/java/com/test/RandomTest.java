package com.test;

import java.util.Random;

/**
 * Created by liusong on 2018/7/11.
 */
public class RandomTest {

    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt(1000));
        }
    }
}
