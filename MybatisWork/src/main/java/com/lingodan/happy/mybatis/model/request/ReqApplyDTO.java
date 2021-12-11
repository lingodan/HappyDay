package com.lingodan.happy.mybatis.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 投保请求对象
 */
@Data
public class ReqApplyDTO{

    private String name;

    @NotNull(message = "证件类型不能为空")
    private Integer idType;

    @NotBlank(message = "证件号码不能为空")
    private String idNo;

    private String phone;

}
