package com.thinkingme.train.test.enumTest;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/8/31 14:15
 */
public enum Operator {

    /**
     *
     */
    ADD {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    },
    /**
     *
     */
    MULTIPLY {
        @Override
        public int apply(int a, int b) {
            return a + b;
        }
    };

    public abstract int apply(int a, int b);
}
