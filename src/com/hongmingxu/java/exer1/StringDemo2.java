package com.hongmingxu.java.exer1;

import org.junit.Test;

/**
 * @author hongmingxu
 * @create 2022-03-13 13:46
 */
public class StringDemo2 {
    //获取两个字符串的最大相同子串(两个字符串中只有一个最大相同字串）
    public String getMaxSameString(String str1,String str2){
        String maxStr = (str1.length()>=str2.length())?str1:str2;
        String minStr = (str1.length()<str2.length())?str1:str2;
        int length = minStr.length();
        if (str1 != null && str2 != null) {
            for(int i = 0;i<length;i++){
                for(int x = 0,y = length - i;y<=length;x++,y++){
                    String subStr = minStr.substring(x, y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }
                }
            }
        }
        return null;
    }
    @Test
    public void testGetMaxSameString(){
        String str1 = "fdjshgoshienkdsjov";
        String str2 = "htenkds";
        String maxSameString = getMaxSameString(str1, str2);
        System.out.println(maxSameString);

    }
}
