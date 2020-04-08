package com.chiang.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "spring.clould.chiang.separation")
public class SeparationProperties {

    private final Map<String, String> config = new HashMap<>();

    public Map<String, String> getConfig() {
        return this.config;
    }
}
