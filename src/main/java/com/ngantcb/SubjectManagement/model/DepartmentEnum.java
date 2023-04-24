package com.ngantcb.SubjectManagement.model;

import javax.annotation.Nullable;
import java.util.Objects;

public enum DepartmentEnum {
    DEPARTMENT1("Department1"),
    DEPARTMENT2("Department2");

    private final String id;

    DepartmentEnum(String id) {
        this.id = id;
    }

    @Nullable
    public static DepartmentEnum fromId(String id){
        for (DepartmentEnum value : DepartmentEnum.values()) {
            if (Objects.equals(id, value.getId())) return value;
        }
        return null;
    }

    public String getId() {
        return id;
    }
}
