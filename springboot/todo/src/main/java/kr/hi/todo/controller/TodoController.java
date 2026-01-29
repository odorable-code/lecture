package kr.hi.todo.controller;

import kr.hi.todo.model.vo.Todo;
import kr.hi.todo.service.TodoService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("")
    public ResponseEntity<List<Todo>> GetTodos() {
        List<Todo> list = todoService.getTodos();
        return ResponseEntity.ok(list);
    }

    @PostMapping("")
    public ResponseEntity<String> postTodo(
        @RequestBody Todo todo
    ) {
        System.out.println(todo);
        String msg;
        boolean res = todoService.postTodo(todo);
        if (res) {
            msg = "할 일을 추가했습니다.";
        } else {
            msg = "할 일을 추가하지 못했습니다.";
        }
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/{num}")
    public ResponseEntity<String> deleteTodo(
        @PathVariable("num") int num
    ) {
        boolean res = todoService.deleteTodo(num);
        if (res) {
            return ResponseEntity.ok("삭제되었습니다.");
        }
        return ResponseEntity.ok("삭제되지 않았습니다.");
    }
}
