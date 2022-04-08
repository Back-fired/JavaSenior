package com.hongmingxu.java.java8;

import com.hongmingxu.java.Reflection.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hongmingxu
 * @create 2022-03-23 21:05
 */
public class PersonData {
    public static List<Person> getPerson(){
        List<Person> list = new ArrayList<>();
        list.add(new Person("trom",12));
        list.add(new Person("trdf",32));
        list.add(new Person("trstg",42));
        list.add(new Person("efsf",43));
        list.add(new Person("grg",64));
        list.add(new Person("wsfm",65));
        list.add(new Person("ytrehm",23));
        list.add(new Person("bgg",34));
        list.add(new Person("adfa",65));
        list.add(new Person("ger",54));
        return list;
    }
}
