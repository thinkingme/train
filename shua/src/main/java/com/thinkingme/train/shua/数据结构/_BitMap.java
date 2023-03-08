package com.thinkingme.train.shua.数据结构;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Random;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/4/20 11:52
 */
public class _BitMap {
    class MyBitSet {
        private Long[] words;
        private int size;

        public MyBitSet(int size) {
            this.size = size;
            words = new Long[size];
        }

        public void set(int bitIndex) {
            int wordIndex = bitIndex >> 6;
            words[wordIndex] |= 1L << bitIndex;
        }

        public boolean get(int bitIndex) {
            int wordIndex = bitIndex >> 6;
            return (words[wordIndex] & (1L << bitIndex)) != 0;
        }


    }
    public static void main(String[] args)
    {
        Random random=new Random();

        List<Integer> list=new ArrayList<>();
        for(int i=0;i<10;i++)
        {
            int randomResult=random.nextInt(100000000);
            list.add(randomResult);
        }
//        System.out.println("产生的随机数有");
//        for(int i=0;i<list.size();i++)
//        {
//            System.out.println(list.get(i));
//        }
        BitSet bitSet=new BitSet(100000000);
        for(int i=0;i<10000000;i++)
        {
            bitSet.set(list.get(i));
        }

        System.out.println("0~1亿不在上述随机数中有"+bitSet.cardinality());
        for (int i = 0; i < 100000000; i++)
        {
            if(!bitSet.get(i))
            {
                System.out.println(i);
            }
        }
    }
}
