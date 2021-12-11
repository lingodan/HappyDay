package com.lingodan.happy.mybatis.controller;

import com.lingodan.happy.mybatis.model.request.InsuranceRequestDTO;
import com.lingodan.happy.mybatis.model.request.ReqApplyDTO;
import com.lingodan.happy.mybatis.model.response.InsuranceResponseDTO;
import com.lingodan.happy.mybatis.model.response.RespApplyDTO;
import com.lingodan.happy.mybatis.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/insurance")
public class ApplyController {

    @Autowired
    private ApplyService applyService;

    @PostMapping("/apply")
    public InsuranceResponseDTO<RespApplyDTO> apply(@Validated @RequestBody InsuranceRequestDTO<ReqApplyDTO> reqApplyDTO) {
        return applyService.execute(reqApplyDTO);
    }

}
