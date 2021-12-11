package com.lingodan.happy.mybatis.model.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 基础请求对象
 */
@Data
public class InsuranceRequestDTO<T> {

    @NotBlank(message = "请求ID不能为空")
    private String requestId;

    /**
     * Marks a property, method parameter or method return type for validation cascading.
     */
    @Valid
    @NotNull(message = "Data节点不能为空")
    private T data;

}
