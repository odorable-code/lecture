package kr.hi.boot.controller;

import kr.hi.boot.model.dto.CommentResponseDTO;
import kr.hi.boot.model.util.Criteria;
import kr.hi.boot.model.util.CustomUser;
import kr.hi.boot.model.util.PageMaker;
import kr.hi.boot.model.vo.Comment;
import kr.hi.boot.service.CommentService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CommentController {
    private  final CommentService commentService;
    // 생성자를 이용한 의존성 주입
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("posts/{num}/comments")
    public ResponseEntity<CommentResponseDTO> getComments(
        @PathVariable("num") int num,
        Criteria cri
    ) {
        cri.setPerPageNum(5);
        //서비스에게 게시글 번호와 페이지 정보를 주면서 댓글 목록 가져오라고 요청
        //댓글목록 = 서비스야.댓글목록가져와(게시글번호, 페이지정보);
        List<Comment> list = commentService.getComments(num, cri);

        //서비스에게 게시글 번호와 페이지 정보를 주면서 PageMaker 객체를 가져오라고 요청
        //PageMaker객체 = 서비스야.PageMaker객체가져와(게시글번호, 페이지정보)
        PageMaker pm = commentService.getPageMaker(num, cri);

        //가져온 댓글 목록과 페이지네이션정보를 화면에 전달
        CommentResponseDTO dto = new CommentResponseDTO(list, pm);
        return ResponseEntity.ok(dto);
    }
    @PostMapping("posts/{num}/comments")
    public ResponseEntity<String> getCommentsPost(
        @PathVariable("num") int num,
        @RequestBody Comment comment,
        @AuthenticationPrincipal CustomUser user
    ) {
        comment.setPostNum(num);
        String result = commentService.insertComment(comment, user);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/posts/{postNum}/comments/{coNum}")
    public ResponseEntity<String> deleteComment(
        @PathVariable("coNum") int coNum,
        @AuthenticationPrincipal CustomUser user
    ) {
        String result = commentService.deleteComment(coNum, user);
        return ResponseEntity.ok(result);
    }

 }