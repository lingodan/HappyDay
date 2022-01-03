package com.lingodan.happy.happyredis.config;

import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedissonConfigTest {

    @Autowired
    private RedissonClient redissonClient;

    @Test
    void clientTest() {
        System.out.println(redissonClient);
    }


    @Test
    void name() {
    }
}