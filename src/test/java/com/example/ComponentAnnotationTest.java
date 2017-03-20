package com.example;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by yanglikun on 2017/3/17.
 */
@AnnotationC
public class ComponentAnnotationTest {

    public static void main(String[] args) {
        Class<ComponentAnnotationTest> clazz = ComponentAnnotationTest.class;
        System.out.println(clazz.getAnnotation(AnnotationA.class));
        System.out.println(clazz.getAnnotation(AnnotationB.class));
        System.out.println(clazz.getAnnotation(AnnotationC.class));
    }
}

@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationA {

}

@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationB {

}

@AnnotationA
@AnnotationB
@Retention(RetentionPolicy.RUNTIME)
@interface AnnotationC {

}
