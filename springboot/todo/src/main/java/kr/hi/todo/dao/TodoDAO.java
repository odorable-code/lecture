package kr.hi.todo.dao;

import kr.hi.todo.model.vo.Todo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TodoDAO {
    List<Todo> selectTodos();

    boolean insertTodo(@Param("todo") Todo todo);

    List<Todo> selectTodosByDate(Date date);

    boolean deleteTodo(@Param("num") int num);
}
