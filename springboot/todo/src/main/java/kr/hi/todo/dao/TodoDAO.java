package kr.hi.todo.dao;

import kr.hi.todo.model.vo.Todo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TodoDAO {
    List<Todo> selectTodos(String date);

    boolean insertTodo(@Param("todo") Todo todo);

    boolean deleteTodo(@Param("num") int num);

    boolean updateTodo(@Param("todo") Todo todo);
}
