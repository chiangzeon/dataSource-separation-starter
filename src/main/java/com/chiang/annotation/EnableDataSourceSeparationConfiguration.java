package com.chiang.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableDataSourceReadWriteSeparation
public @interface EnableDataSourceSeparationConfiguration {
}
