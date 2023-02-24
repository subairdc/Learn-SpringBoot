package com.subairdc.spring.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.subairdc.spring.springaop.model.Department;
import com.subairdc.spring.springaop.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect {

//    @Pointcut("execution(* com.subairdc.spring.springaop.controller.*.*(..))")
//    @Pointcut("within(com.subairdc.spring.springaop.service..*)")
//    @Pointcut("this(com.subairdc.spring.springaop.service.DepartmentService)")
	@Pointcut("@annotation(com.subairdc.spring.springaop.annotation.CustomAnnotation)")
	public void loggingPointCut(){}

    @Before("loggingPointCut()")
    public void before( JoinPoint joinPoint ){
        log.info("Before method invoked::"+joinPoint.getSignature());
    }
    
//    @After("loggingPointCut()")
//    public void after( JoinPoint joinPoint ){
//        log.info("After method invoked::"+joinPoint.getSignature());
//    }
    
//    @AfterReturning(value = "execution(* com.subairdc.spring.springaop.controller.*.*(..))",
//            returning = "employee")
//    public void after( JoinPoint joinPoint, Employee employee ){
//        log.info("After method invoked::"+employee);
//    }
//    
//    @AfterThrowing(value = "execution(* com.subairdc.spring.springaop.controller.*.*(..))",
//            throwing = "e")
//    public void after( JoinPoint joinPoint, Exception e ){
//        log.info("After method invoked::"+e.getMessage());
//    }
//
//
    @Around("loggingPointCut()")
    public Object around( ProceedingJoinPoint joinPoint ) throws Throwable {
        log.info("Before method invoked::"+joinPoint.getArgs()[0]);
        Object object = joinPoint.proceed();

        if(object instanceof Employee){
        	log.info("After method invoked..."+joinPoint.getSignature());
            log.info("After method invoked..."+joinPoint.getArgs()[0]);
        }else if(object instanceof Department){
            log.info("After method invoked..."+joinPoint.getSignature());
            log.info("After method invoked..."+joinPoint.getArgs()[0]);
        }

        return object;
    }

}