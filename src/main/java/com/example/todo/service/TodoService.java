package com.example.todo.service;

import com.example.todo.domain.Todo;
import com.example.todo.repository.TodoDao;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoDao todoDao;
    public List<Todo> getTodos() {
        return todoDao.findAll();
    }

    public Todo updateTodo(Long id) { // 업데이트할때 id를 받아올 수 있도록 인자 설정
        Todo updateTodo = todoDao.findById(id); // id 값을 가지고 dao 를 얻어옴
        updateTodo.setDone(!updateTodo.isDone()); // 원래 업데이트 했던 것에서 반대로하고 싶다.
        todoDao.update(updateTodo);
        return updateTodo;
    }

    public void deleteTodo(Long id) {
        // Dao 의 delete 메서드에 id 를 넘겨서 삭제를 진행!
        todoDao.delete(id);
    }

    public void addTodo(String content) {
        todoDao.save(content);
    }

}


