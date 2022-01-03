package com.lingodan.happy.happyredis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {
    /**
     * 初始化RedissonClient
     *
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient initial() {
        Config config = new Config();
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

//        config.useClusterServers()
//                .setScanInterval(2000) // 每2000毫秒扫描集群
//                .addNodeAddress("redis://127.0.0.1:6371", "redis://127.0.0.1:6372",
//                        "redis://127.0.0.1:6373").setPassword("1234");

        config.useClusterServers()
                .setScanInterval(2000) // 每2000毫秒扫描集群
                .addNodeAddress("redis://192.168.3.20:6371", "redis://192.168.3.20:6372",
                        "redis://192.168.3.20:6373").setPassword("1234");

        return Redisson.create(config);
    }

}
