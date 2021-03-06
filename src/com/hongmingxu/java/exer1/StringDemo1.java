package com.hongmingxu.java.exer1;

import org.junit.Test;

/**
 * @author hongmingxu
 * @create 2022-03-13 11:16
 */
public class StringDemo1 {
    //获取一个字符串在另一个字符串中出现的次数

    /**
     * 获取subStr在mainStr中出现的次数
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength) {
            //方式一
//            while((index = mainStr.indexOf(subStr)) != -1) {
//                count++;
//                mainStr = mainStr.substring(index+subStr.length());
//            }
            //方式二
            while ((index = mainStr.indexOf(subStr, index)) != -1) {
                count++;
                index += subLength;
            }
            return count;
        }else{
            return 0;
        }
    }

    @Test
    public void testGetCount(){
        String mainStr = "dsjhfiohjhjjhgh";
        String subStr = "jh";
        int count = getCount(mainStr,subStr);
        System.out.println(count);
    }
}
