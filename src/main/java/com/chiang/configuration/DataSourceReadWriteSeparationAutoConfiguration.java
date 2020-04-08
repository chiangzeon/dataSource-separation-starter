package com.chiang.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.chiang.aop.SeparationPointCut;
import com.chiang.dataSource.RoutingDataSourceImpl;
import com.chiang.enumerate.DataSourceEnum;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@ConditionalOnClass(DruidDataSource.class)
@ConditionalOnMissingBean(DataSource.class)
public class DataSourceReadWriteSeparationAutoConfiguration {

    @Bean
    public SeparationPointCut separationPointCut() {
        return new SeparationPointCut();
    }

    @Bean(value = "read")
    @ConfigurationProperties(value = "spring.cloud.chiang.separation.read")
    public DataSource read() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean(value = "write")
    @ConfigurationProperties(value = "spring.cloud.chiang.separation.write")
    public DataSource write() {
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }

    @Bean("dataSource")
    @Primary
    public DataSource dataSource(@Qualifier("read") DataSource read, @Qualifier("write") DataSource write) {
        Map<Object, Object> targetDataSources = new HashMap<>(2);
        RoutingDataSourceImpl dataSource = new RoutingDataSourceImpl();
        targetDataSources.put(DataSourceEnum.read, read);
        targetDataSources.put(DataSourceEnum.write, write);
        dataSource.setDefaultTargetDataSource(read);
        dataSource.setTargetDataSources(targetDataSources);
        return dataSource;
    }

}
