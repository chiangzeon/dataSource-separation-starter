package com.chiang.aop;

import com.chiang.annotation.Separation;
import com.chiang.dataSource.RoutingDataSourceImpl;
import com.chiang.enumerate.DataSourceEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class SeparationPointCut {

    @Pointcut("@annotation(com.chiang.annotation.Separation)")
    public void pointCut() {
    }

    @Around(value = "pointCut()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        try {
            MethodSignature signature = (MethodSignature) point.getSignature();
            Method method = signature.getMethod();
            boolean exists = method.isAnnotationPresent(Separation.class);
            if (exists) {
                Separation separation = method.getAnnotation(Separation.class);
                DataSourceEnum dataSourceEnum = separation.dataSource();
                RoutingDataSourceImpl.setDataSource(dataSourceEnum);
            }
            point.proceed(point.getArgs());
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            RoutingDataSourceImpl.clearDataSource();
        }
    }
}
