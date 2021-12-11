package com.lingodan.happy.mybatis.service;


import com.alibaba.fastjson.JSONObject;
import com.lingodan.happy.mybatis.model.request.InsuranceRequestDTO;
import com.lingodan.happy.mybatis.model.request.ReqApplyDTO;
import com.lingodan.happy.mybatis.model.response.InsuranceResponseDTO;
import com.lingodan.happy.mybatis.model.response.RespApplyDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class ApplyService {


    public InsuranceResponseDTO<RespApplyDTO> execute(InsuranceRequestDTO<ReqApplyDTO> reqApplyDTO) {
        log.info("Apply Params:{}", JSONObject.toJSONString(reqApplyDTO));
        InsuranceResponseDTO<RespApplyDTO> retDTO= new InsuranceResponseDTO<>();
        RespApplyDTO respApplyDTO = new RespApplyDTO();
        retDTO.setRetCode("00");
        retDTO.setRetMsg("成功");
        retDTO.setRequestId(reqApplyDTO.getRequestId());
        respApplyDTO.setPolicyNo("HP" + Instant.now().getEpochSecond());
        retDTO.setData(respApplyDTO);
        log.info("Return Result:{}", JSONObject.toJSONString(retDTO));
        return retDTO;
    }

}
