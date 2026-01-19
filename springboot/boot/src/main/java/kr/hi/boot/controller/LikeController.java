package kr.hi.boot.controller;

import kr.hi.boot.model.util.CustomUser;
import kr.hi.boot.model.vo.Like;
import kr.hi.boot.service.LikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    /* 메서드 추가
       url: /api/v2/posts/게시글번호/like
       method: post
       화면에 문자열 전달
     */
    @PostMapping("/posts/{postNum}/like")
    public ResponseEntity<String> postLike(
        @PathVariable("postNum") int postNum,
        @AuthenticationPrincipal CustomUser user
    ) {
        String msg = likeService.postLike(postNum, user);
        return ResponseEntity.ok(msg);
    }
}