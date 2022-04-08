package com.hongmingxu.java.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * @author hongmingxu
 * @create 2022-03-23 23:06
 */
public class OptionalTest {
    @Test
    public void test1(){
        Girl girl = new Girl();
        girl = null;
        //保证是非空
        Optional<Girl> optionalGirl = Optional.of(girl);

    }
    @Test
    public void test2(){
        Girl girl = new Girl();
        girl = null;
        //可以为null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);

    }
}
