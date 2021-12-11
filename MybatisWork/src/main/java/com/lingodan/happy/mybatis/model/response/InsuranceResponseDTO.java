package com.lingodan.happy.mybatis.model.response;

import lombok.Data;

/**
 * 基础响应对象
 */
@Data
public class InsuranceResponseDTO<T> {
    /**
     * 响应状态
     */
    private String retCode;
    /**
     * 响应状态信息
     */
    private String retMsg;

    /**
     * 同请求ID
     */
    private String requestId;

    private T data;
}
