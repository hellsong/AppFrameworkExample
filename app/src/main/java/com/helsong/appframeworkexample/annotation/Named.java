package com.helsong.appframeworkexample.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import javax.inject.Qualifier;

/**
 * Created by weiruyou on 2015/5/19.
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface Named {
    String value() default "";
}
