package com.hongmingxu.java.exer1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hongmingxu
 * @create 2022-03-15 20:17
 */
public class ListExer {
    @Test
    public void testListRemove(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }
    private void updateList(List list){
        list.remove(2);
        list.remove(new Integer(2));
    }
}
