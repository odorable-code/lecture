package kr.hi.todo.controller;

import kr.hi.todo.model.vo.Todo;
import kr.hi.todo.service.TodoService;
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
    public ResponseEntity<List<Todo>> GetTodos(
        @RequestParam("date") String date
    ) {
       // 서비스에서 date를 처리하는데,
       // yyyy-MM-dd 형식이 아니면 전체조회로, yyyy-MM-dd 형식이면 날짜에 맞는 할일을 조회
        List<Todo> list = todoService.getTodos(date);
        System.out.println(list);
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
    @PutMapping("/{num}")
    public ResponseEntity<Boolean> deleteTodo(
        @PathVariable("num") int num,
        @RequestBody Todo todo
    ) {
        boolean res = todoService.updateTodo(todo);
        return ResponseEntity.ok(res);
    }
}

