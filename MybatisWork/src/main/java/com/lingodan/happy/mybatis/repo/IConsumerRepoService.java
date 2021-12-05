package com.lingodan.happy.mybatis.repo;


import com.lingodan.happy.mybatis.entity.Consumer;

public interface IConsumerRepoService {

    Consumer getById(Long id);

//    Consumer getByName(String name);
//
    boolean insertOne(Consumer entity);

    boolean modifyOne(Consumer entity);
//
    boolean deleteOne(Long id);

}
