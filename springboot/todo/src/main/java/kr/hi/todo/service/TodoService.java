package kr.hi.todo.service;

import kr.hi.todo.dao.TodoDAO;
import kr.hi.todo.model.vo.Todo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Service
public class TodoService {
    private final TodoDAO todoDAO;

    public TodoService(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    public List<Todo> getTodos() {
        return todoDAO.selectTodos();
    }

    public boolean postTodo(Todo todo) {
        return todoDAO.insertTodo(todo);
    }

    public List<Todo> getTodosByDate(Date date) {
        return todoDAO.selectTodosByDate(date);
    }

    public boolean deleteTodo(int num) {
        return todoDAO.deleteTodo(num);
    }
}
