package com.eastwood.pattern.viewstate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class ViewUtil {

    public static <T> Class<T> getTypeClass(Class typeClass, Class targetClass) {
        Type type = typeClass.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypes = parameterizedType.getActualTypeArguments();
            for (Type actualType : actualTypes) {
                if (actualType instanceof Class) {
                    Class actualTypeClass = (Class) actualType;
                    if (targetClass.isAssignableFrom(actualTypeClass)) {
                        return actualTypeClass;
                    }
                }
            }
        }

        Class superClass = typeClass.getSuperclass();
        if (superClass == null) {
            return null;
        }
        return getTypeClass(superClass, targetClass);
    }

}
