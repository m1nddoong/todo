package com.example.todo.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class Person {
    @NotNull // 이 필드의 값이 널값은 안들어왔으면 좋겠고 -> validation 의존성 추가
    @Size(min = 2, max = 20)  // 이름은 최소 2자 이상 최대 10자
    private String name;

    @Min(15) // 최소 15세 이상이였으면 좋겠다
    private int age;
}
