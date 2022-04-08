package com.hongmingxu.java.Class3;

import java.util.List;

/**
 * @author hongmingxu
 * @create 2022-03-17 22:06
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1001",new User(1001,34,"周杰伦"));
        dao.save("1002",new User(1002,20,"昆凌"));
        dao.save("1003",new User(1003,35,"蔡依林"));
        dao.update("1003",new User(1003,23,"方文山"));
        dao.delete("1002");
        List<User> list = dao.list();
        list.forEach(System.out::println);
    }
}
