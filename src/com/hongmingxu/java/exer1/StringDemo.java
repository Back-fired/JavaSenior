package com.hongmingxu.java.exer1;

import org.junit.Test;

/**
 * @author hongmingxu
 * @create 2022-03-13 10:37
 */
public class StringDemo {
    //将一个字符串进行反转，将字符串中指定部分进行反转。
    public String reverse(String str,int startIndex,int endIndex){
        //方式一：转换为char[]
        if (str != null) {
            char[] arr = str.toCharArray();
            for (int x = startIndex,y = endIndex;x<y;x++,y--){
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    public String reverse1(String str,int startIndex,int endIndex){
        //方式二：使用String的拼接
        if (str != null) {
            String reverseStr = str.substring(0,startIndex);
            for (int i = endIndex;i>=startIndex;i--){
                reverseStr += str.charAt(i);
            }
            reverseStr += str.substring(endIndex + 1);

            return reverseStr;
        }
        return null;
    }

    public String reverse2(String str,int startIndex,int endIndex){
        //方式三：使用StringBuffer/StringBuilder替换String
        if (str != null) {
            StringBuilder builder = new StringBuilder(str.length());

            builder.append(str.substring(0,startIndex));

            for (int i = endIndex;i>=startIndex;i--){
                builder.append(str.charAt(i));
            }
            builder.append(str.substring(endIndex+1));
            return builder.toString();
        }
        return null;
    }

    @Test
    public void testReverse(){
        String str = "sajdfihoiu";
        String reverse = reverse(str, 2, 5);
        System.out.println(reverse);
        String reverse1 = reverse1(str, 2, 5);
        System.out.println(reverse1);
        String reverse2 = reverse2(str, 2, 5);
        System.out.println(reverse2);
    }
}
