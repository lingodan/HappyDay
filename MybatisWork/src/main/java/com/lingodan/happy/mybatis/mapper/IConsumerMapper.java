package com.lingodan.happy.mybatis.mapper;

import com.lingodan.happy.mybatis.entity.Consumer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface IConsumerMapper {

    Consumer getOneByById(Long id);

//    Consumer getOneByName(String name);
//
    boolean insertOne(Consumer entity);

    boolean modifyOne(Consumer entity);

    boolean deleteOne(Long id);

}
