package com.zwx.guatalumni.common.utils;

import org.springframework.core.MethodParameter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author liuyz
 * @Description
 * @date 2021/6/3 8:11
 */
public class AnnotationUtils {
    /**
     * 从父接口库的对应方法中的参数上找指定注解
     *
     * @param parameter       方法
     * @param annotationClazz 注解类型
     * @param <T>             类型泛型
     * @return 找到的注解，未找到范围null
     */
    public static <T extends Annotation> T findAnnotationInParentMethodParameter(MethodParameter parameter, Class<T> annotationClazz) {
        if (!parameter.hasParameterAnnotation(annotationClazz)) {
            for (Class<?> interfaceClass : parameter.getDeclaringClass().getInterfaces()) {
                try {
                    Method interfaceMethod = interfaceClass.getMethod(parameter.getMethod().getName(), parameter.getMethod().getParameterTypes());
                    MethodParameter interfaceMethodParameter = new MethodParameter(interfaceMethod, parameter.getParameterIndex());
                    if (interfaceMethodParameter.hasParameterAnnotation(annotationClazz)) {
                        return interfaceMethodParameter.getParameterAnnotation(annotationClazz);
                    }
                } catch (NoSuchMethodException | NullPointerException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
