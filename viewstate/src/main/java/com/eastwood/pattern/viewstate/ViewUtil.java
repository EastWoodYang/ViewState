package com.eastwood.pattern.viewstate;

import java.lang.reflect.ParameterizedType;

class ViewUtil {

    public static <T> Class<T> getTypeClass(Object object, int position) {
        return (Class) ((ParameterizedType) (object.getClass()
                .getGenericSuperclass())).getActualTypeArguments()[position];
    }

}
