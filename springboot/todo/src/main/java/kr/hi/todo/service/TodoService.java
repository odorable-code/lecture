package kr.hi.todo.service;

import kr.hi.todo.dao.TodoDAO;
import kr.hi.todo.model.vo.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoDAO todoDAO;

    public TodoService(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    public List<Todo> getTodos(String date) {
        return todoDAO.selectTodos(date);
    }

    public boolean postTodo(Todo todo) {
        return todoDAO.insertTodo(todo);
    }

    public boolean deleteTodo(int num) {
        try {
            return todoDAO.deleteTodo(num);
        } catch (Exception err) {
            err.printStackTrace();
            return false;
        }
    }
    public boolean updateTodo(Todo todo) {
        try  {
            return todoDAO.updateTodo(todo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
