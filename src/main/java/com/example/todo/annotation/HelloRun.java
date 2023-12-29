package com.example.todo.annotation;

import java.lang.reflect.Method;

public class HelloRun {
    public static void main(String[] args) throws NoSuchMethodException {
        Hello hello = new Hello();

        // 메서드를 얻어와서 객체에 저장
        Method method = hello.getClass().getDeclaredMethod("print"); // print 라는 메서드의 정보를 얻어와
        if (method.isAnnotationPresent(count100.class)) { // 만약 이 메서드가 count100 이라는 애너테이션을 갖고 있어? 라는 뜻
            for (int i = 0; i < 100; i++) {
                hello.print();
            }
        } else {
            hello.print();
        }
    }
}
