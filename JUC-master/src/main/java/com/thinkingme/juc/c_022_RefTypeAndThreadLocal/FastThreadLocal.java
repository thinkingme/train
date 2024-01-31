package com.thinkingme.juc.c_022_RefTypeAndThreadLocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 27/12/2023 下午1:40
 */
public class FastThreadLocal {
    private final int threadLocalHashCode = nextHashCode();

    /**
     * The next hash code to be given out. Updated atomically. Starts at
     * zero.
     */
    private static AtomicInteger nextHashCode =
            new AtomicInteger();

    /**
     * The difference between successively generated hash codes - turns
     * implicit sequential thread-local IDs into near-optimally spread
     * multiplicative hash values for power-of-two-sized tables.
     */
    private static final int HASH_INCREMENT = 0x61c88647;

    /**
     * Returns the next hash code.
     */
    private static int nextHashCode() {
        return nextHashCode.getAndAdd(HASH_INCREMENT);
    }

    public static void main(String[] args) {
        FastThreadLocal fastThreadLocal = new FastThreadLocal();
        System.out.printf(String.valueOf(fastThreadLocal.threadLocalHashCode));
        nextHashCode();
        System.out.printf(String.valueOf(fastThreadLocal.threadLocalHashCode));
        nextHashCode();
        System.out.printf(String.valueOf(fastThreadLocal.threadLocalHashCode));
    }
}
