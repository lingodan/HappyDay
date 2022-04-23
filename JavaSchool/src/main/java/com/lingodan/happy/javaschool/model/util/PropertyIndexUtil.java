package com.lingodan.happy.javaschool.model.util;

import com.lingodan.happy.javaschool.model.property.PropertyIndex;

import java.lang.reflect.Field;
import java.util.List;

public class PropertyIndexUtil {

    public static PropertyIndex fetchIndex(List objects, String filedName) {
        if (filedName == null || filedName.trim().length() == 0) {
            return null;
        }
        if (objects == null || objects.size() == 0) {
            return null;
        }
        PropertyIndex propertyIndex = new PropertyIndex();
        for (int i = 0; i < objects.size(); i++) {
            Field field = getFieldByClass(filedName, objects.get(i));
            if (field != null) {
                try {
                    field.setAccessible(true);
                    propertyIndex.addIndexByValue((String) field.get(objects.get(i)), i);
                } catch (IllegalAccessException e) {
                    System.out.println("Exception....");
                }
            }
        }
        return propertyIndex;
    }


    private static Field getFieldByClass(String fieldName, Object object) {
        Field field = null;
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
            } catch (Exception e) {
                System.out.println(clazz.getClass().getSimpleName() + "没有属性" + fieldName);
            }
        }
        return field;
    }


}
