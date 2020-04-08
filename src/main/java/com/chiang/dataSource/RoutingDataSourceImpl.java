package com.chiang.dataSource;

import com.chiang.enumerate.DataSourceEnum;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSourceImpl extends AbstractRoutingDataSource {

    private static final ThreadLocal<DataSourceEnum> CONTEXT_HOLDER = new ThreadLocal<>();

    protected Object determineCurrentLookupKey() {
        DataSourceEnum dataSourceEnum = CONTEXT_HOLDER.get();
        return dataSourceEnum;
    }

    public static void setDataSource(DataSourceEnum dataSource) {
        CONTEXT_HOLDER.set(dataSource);
    }

    public static DataSourceEnum getDataSource() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSource() {
        CONTEXT_HOLDER.remove();
    }
}
