package com.example.todo.annotation;



public class Hello {
    @count100 // 만약에 여기에 애너테이션이 붙는다면
    public void print() {
        System.out.println("Hello World!");
    }
}
