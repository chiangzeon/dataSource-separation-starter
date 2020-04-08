package com.chiang.annotation;

import com.chiang.selector.EnableDataSourceReadWriteSeparationImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(EnableDataSourceReadWriteSeparationImportSelector.class)
public @interface EnableDataSourceReadWriteSeparation {
}
