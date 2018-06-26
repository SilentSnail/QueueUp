package com.test.tool;

/**
 * Created by liusong on 2018/5/30.
 */
public class BinaryTest {

    public static void main(String[] args) {
        String result = strToBinaryString("把你自己捏出去？");
        System.out.println("字符串转二进制");
        System.out.println(result);
        System.out.println("二进制转回字符串");
        result = binstrToString(result);
        System.out.println(result);
    }

    /**
     * 字符串转二进制
     * @param str
     * @return
     */
    public static String strToBinaryString(String str){
        char[] chars = str.toCharArray();
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            bf.append(Integer.toBinaryString(chars[i]));
            bf.append(" ");
        }
        return bf.toString();
    }

    public static Integer[] binaryToIntArray(String binStr){
        char[] chars = binStr.toCharArray();
        Integer[] result = new Integer[chars.length];
        for(int i=0;i<chars.length;i++) {
            result[i]=chars[i]-48;
        }
        return result;
    }

    public static char BinstrToChar(String binStr){
        Integer[] temp=binaryToIntArray(binStr);
        int sum=0;
        for(int i=0; i<temp.length;i++){
            sum += temp[temp.length-1-i]<<i;
        }
        return (char)sum;
    }

    public static String binstrToString(String binStr){
        String[] tempStr=binStr.split(" ");
        char[] tempChar=new char[tempStr.length];
        for(int i=0;i<tempStr.length;i++) {
            tempChar[i]=BinstrToChar(tempStr[i]);
        }
        return String.valueOf(tempChar);
    }
}