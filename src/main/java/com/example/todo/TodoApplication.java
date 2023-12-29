package com.example.todo;

import com.example.todo.domain.Todo;
import com.example.todo.repository.TodoDao;
import java.util.List;
import org.graalvm.collections.EconomicMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @Autowired
    TodoDao todoDao;
    @Override
    public void run(String... args) throws Exception {
//        List<Todo> todos =  todoDao.findAll();
//        System.out.println(todos.size());
//        for(Todo todo : todos){
//            System.out.println(todo);
//        }

        // 저장하기
//        todoDao.save("todo만들기2");
        // 수정하기
        Todo todo = new Todo();
        todo.setId(1L);
        todo.setDone(true);
        // todoDao.update(todo);
        // 삭제하기
        // todoDao.delete(1L);
        System.out.println(todoDao.findById(11L)); // id 가 2번인 데이터 얻어오기
    }
}