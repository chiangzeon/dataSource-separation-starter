package com.chiang.annotation;

import com.chiang.enumerate.DataSourceEnum;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Separation {

    DataSourceEnum dataSource() default DataSourceEnum.read;
}
