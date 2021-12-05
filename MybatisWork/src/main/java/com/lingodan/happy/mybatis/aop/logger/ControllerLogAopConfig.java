package com.lingodan.happy.mybatis.aop.logger;


import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class ControllerLogAopConfig {


    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMethodController() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void deleteMethodController() {
    }

    //       请求地址 / 入口类、方法 / 请求参数
    @Before("getMethodController()")
    public void getMethodAdvice(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("[REQUEST:GET{}]{}#{}:{}", request.getRequestURI(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), JSONObject.toJSONString(joinPoint.getArgs()));
    }

    @Before("deleteMethodController()")
    public void deleteMethodAdvice(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("[REQUEST:DELETE{}]{}#{}:{}", request.getRequestURI(), joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName(), JSONObject.toJSONString(joinPoint.getArgs()));
    }

}
