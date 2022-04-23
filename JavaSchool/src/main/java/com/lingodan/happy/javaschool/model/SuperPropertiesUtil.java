package com.lingodan.happy.javaschool.model.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class SuperPropertiesUtil {

    public static List getValueByName(List objects, String filedName, String fieldValue) {
        if (filedName == null || filedName.trim().length() == 0) {
            return null;
        }
        if (fieldValue == null || fieldValue.trim().length() == 0) {
            return null;
        }
        if (objects == null || objects.size() == 0) {
            return null;
        }
        return (List) objects.stream().filter(obj -> {
            try {
                Field declaredField = getFieldByClass(filedName, obj);
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                    return declaredField.get(obj).equals(fieldValue);
                } else {
                    return false;
                }
            } catch (IllegalAccessException e) {
                return false;
            }
        }).collect(Collectors.toList());
    }


    private static Field getFieldByClass(String fieldName, Object object) {
        Field field = null;
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
            } catch (Exception e) {
                return null;
            }
        }
        return field;
    }
}
