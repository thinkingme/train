package com.thinkingme.train.mian.DuoyiCode;

public class BigMapTest {

    private int[] bigArray;

    public BigMapTest(long  size){
        bigArray = new int[(int) (size/ 32 + 1)];
    }

    public void set1(int  num){
        //确定数组 index
        int arrayIndex = num >> 5;
        //确定bit index
        int bitIndex = num & 31;
        //设置0
        bigArray[arrayIndex] |= 1 << bitIndex;
    }

    public void set0(int  num){
        //确定数组 index
        int arrayIndex = num >> 5;
        //确定bit index
        int bitIndex = num & 31;
        //设置0
        bigArray[arrayIndex] &= ~(1 << bitIndex);
        System.out.println(get32BitBinString(bigArray[arrayIndex]));
    }

    public boolean isExist(int  num){
        //确定数组 index
        int arrayIndex = num >> 5;
        //确定bit index
        int bitIndex = num & 31;

        //判断是否存在
        return (bigArray[arrayIndex] & ((1 << bitIndex)))!=0 ? true : false;
    }

    /**
     * 将整型数字转换为二进制字符串，一共32位，不舍弃前面的0
     * @param number 整型数字
     * @return 二进制字符串
     */
    private static String get32BitBinString(int number) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 32; i++){
            sBuilder.append(number & 1);
            number = number >>> 1;
        }
        return sBuilder.reverse().toString();
    }
    
    public static void main(String[] args) {

        int[] arrays = new int[]{1, 2, 35, 22, 56, 334, 245, 2234, 54};

        BigMapTest bigMapTest = new BigMapTest(2234-1);

        for (int i : arrays) {
            bigMapTest.set1(i);
        }
        System.out.println(bigMapTest.isExist(35));
    }
}

