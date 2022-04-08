package com.hongmingxu.java.Reflection;

import java.io.Serializable;

/**
 * @author hongmingxu
 * @create 2022-03-20 19:34
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
