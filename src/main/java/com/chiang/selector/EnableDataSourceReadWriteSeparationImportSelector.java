package com.chiang.selector;

import com.chiang.annotation.EnableDataSourceReadWriteSeparation;
import org.springframework.cloud.commons.util.SpringFactoryImportSelector;

public class EnableDataSourceReadWriteSeparationImportSelector extends SpringFactoryImportSelector<EnableDataSourceReadWriteSeparation> {
    protected boolean isEnabled() {
        return getEnvironment().getProperty("spring.cloud.chiang.separation.enabled",
                Boolean.class, Boolean.TRUE);
    }
}
