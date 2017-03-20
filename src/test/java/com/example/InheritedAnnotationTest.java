package com.example;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by yanglikun on 2017/3/17.
 */
public class InheritedAnnotationTest {
    public static void main(String[] args) {
        System.out.println(B.class.getAnnotation(InheritedAnno.class));
        System.out.println(B.class.getAnnotation(UnInheritedAnno.class));
    }
}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@interface InheritedAnno {


}

@Retention(RetentionPolicy.RUNTIME)
@interface UnInheritedAnno {

}

@InheritedAnno
@UnInheritedAnno
class A {

}

class B extends A {
    
}