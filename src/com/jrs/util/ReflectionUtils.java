package com.jrs.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    public static void inspectClass(Object obj) {
        if (obj == null) return;

        Class<?> clazz = obj.getClass();
        System.out.println("[Runtime Inspection] Target: " + clazz.getSimpleName());

        // Fields
        System.out.println("Property Metadata:");
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                System.out.printf("  > %s (%s): %s%n", field.getName(), field.getType().getSimpleName(), value);
            } catch (IllegalAccessException e) {
                System.out.println("  > " + field.getName() + ": [Access Restricted]");
            }
        }

        // Methods
        System.out.println("Declared Behavior:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println("  # " + method.getName());
        }
        System.out.println();
    }
}