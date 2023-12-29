package com.example.todo.annotation;

import com.oracle.svm.core.annotate.TargetElement;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 런 타임 시 애너테이션 쓸 것이다.
public @interface count100 {
}
