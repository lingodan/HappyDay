package com.lingodan.happy.mybatis.repo.impl;

import com.lingodan.happy.mybatis.mapper.IConsumerMapper;
import com.lingodan.happy.mybatis.entity.Consumer;
import com.lingodan.happy.mybatis.repo.IConsumerRepoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IConsumerRepoServiceImpl implements IConsumerRepoService {

    @Autowired
    private IConsumerMapper consumerRepo;

    @Override
    public Consumer getById(Long id) {
        return consumerRepo.getOneByById(id);
    }

//    @Override
//    public Consumer getByName(String name) {
//        return consumerRepo.getOneByName(name);
//    }
//
    @Override
    public boolean insertOne(Consumer entity) {
        return consumerRepo.insertOne(entity);
    }

    @Override
    public boolean modifyOne(Consumer entity) {
        return consumerRepo.modifyOne(entity);
    }

    @Override
    public boolean deleteOne(Long id) {
        return consumerRepo.deleteOne(id);
    }
}
