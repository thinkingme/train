package com.thinkingme.train.utils;

import redis.clients.jedis.Jedis;

/**
 * <p>
 *
 * </p>
 *
 * @author: huige
 * @date: 2022/6/28 15:53
 */
public class testRedis {
    public static void main(String[] args) {
        while (true){
            for (int i = 0; i < 1000; i++) {
                new Thread(() -> {
                    try {
                        //连接本地的 Redis 服务
                        Jedis jedis = new Jedis("192.168.3.90",6379);
                        // 如果 Redis 服务设置了密码，需要下面这行，没有就不需要
                        jedis.auth("12345612");
                        System.out.println("连接成功");
                        //查看服务是否运行
                        System.out.println("服务正在运行: "+jedis.ping());
                    }catch (Exception exception){
                        System.out.println(exception.getMessage());
                    }
                }).start();
            }


        }

    }
}
