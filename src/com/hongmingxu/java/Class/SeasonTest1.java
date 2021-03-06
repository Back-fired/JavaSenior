package com.hongmingxu.java.Class;

/**使用enum关键字定义枚举类
 * 定义的枚举类默认继承于java.lang.Enum类
 * @author hongmingxu
 * @create 2022-03-14 19:24
 */
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        //toString()
        System.out.println(summer.toString());

        System.out.println(Season1.class.getSuperclass());

        //values()
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        //valueOf(String objName):根据提供objName名字的返回对象
        //如果没有objName的枚举类对象，会抛异常
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        winter.show();
    }
}

interface Info{
    void show();
}
//使用enum关键字枚举类
enum Season1 implements Info{
    //1.提供当前枚举类的对象,多个对象之间用,隔开，末尾对象;结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    private final String seasonName;
    private final String seasonDesc;

    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //4.其他述求：获取枚举类对象的属性

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show() {
//        System.out.println("这是一个季节");
//    }
}
