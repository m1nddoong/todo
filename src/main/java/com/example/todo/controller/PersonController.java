package com.example.todo.controller;

import com.example.todo.domain.Person;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @GetMapping("/")
    public String form(Person person) { // 여기사 valudation 을 체크할것이기 때문에 얘가 사용하는 모델인 Person
        return "person";
    }

    @PostMapping("/")
    // valid 라고 하는 애노테이션을 붙여줄 것
    public String save(@Valid Person person, BindingResult bindingResult) {
        // 바인딩 에러가 있다면 person 이라는 뷰 네임 리턴
        if (bindingResult.hasErrors()) {
            return "person";
        }
        return "redirect:/todo";
    }
}
