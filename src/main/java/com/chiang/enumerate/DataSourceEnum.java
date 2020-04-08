package com.chiang.enumerate;

public enum DataSourceEnum {

    read("read"),
    write("write");
    public String value;

    DataSourceEnum(String value) {
        this.value = value;
    }

    DataSourceEnum() {
    }

    /*public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }*/
}
