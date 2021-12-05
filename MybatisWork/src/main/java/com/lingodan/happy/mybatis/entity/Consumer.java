package com.lingodan.happy.mybatis.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Consumer {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
