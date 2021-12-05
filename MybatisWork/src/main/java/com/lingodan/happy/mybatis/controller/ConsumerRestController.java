package com.lingodan.happy.mybatis.controller;

import com.alibaba.fastjson.JSONObject;
import com.lingodan.happy.mybatis.entity.Consumer;
import com.lingodan.happy.mybatis.repo.IConsumerRepoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerRestController {

    @Autowired
    private IConsumerRepoService consumerRepoService;

    @GetMapping("/{id}")
    public Consumer queryConsumerById(@PathVariable(value = "id") Long id) {
        Consumer consumer = consumerRepoService.getById(id);
        return consumer;
    }

    @PutMapping("")
    public String addNewConsumer(@RequestBody Consumer consumer) {
        boolean flag = consumerRepoService.insertOne(consumer);
        return String.valueOf(flag);
    }


    @PostMapping("")
    public String modifyConsumer(@RequestBody Consumer consumer) {
        boolean modifyFlag = consumerRepoService.modifyOne(consumer);
        if (modifyFlag) {
            return JSONObject.toJSONString(consumerRepoService.getById(consumer.getId()));
        }
        return String.valueOf(false);
    }

    @DeleteMapping("/{id}")
    public String deleteConsumer(@PathVariable(value = "id") Long id) {
        boolean delFlag = consumerRepoService.deleteOne(id);
        return String.valueOf(delFlag);
    }

}
