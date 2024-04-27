package com.javaweb.enums;

import java.util.Map;
import java.util.TreeMap;

public enum StatusType {
    DXL("đang xử lý"),
    XL("đã  xử lý"),
    CXL("chưa xử lý"),
    ;


    private final String name;

    StatusType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Map<String, String> type() {
        Map<String, String> listType = new TreeMap<>();
        for (StatusType item : StatusType.values()) {
            listType.put(item.toString(), item.name);
        }
        return listType;
    }
}
