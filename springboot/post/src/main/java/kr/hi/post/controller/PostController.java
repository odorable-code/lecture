package kr.hi.post.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import kr.hi.post.model.vo.PostVO;
import kr.hi.post.service.PostService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")
public class PostController {

	private final PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/posts")
	public ResponseEntity<List<PostVO>> postList() {
		List<PostVO> list = postService.getPosts();
		return ResponseEntity.ok(list);
	}

    @PostMapping("/posts")
    public ResponseEntity<Boolean> postInsertPost(
            @RequestBody PostVO post
    ) {
        boolean res = postService.insertPost(post);
        if (res) {
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }

	@GetMapping("/posts/{num}")
	public ResponseEntity<PostVO> postDetail(
        @PathVariable("num") int num
    ) {
		PostVO post = postService.getPost(num);
        if (post != null) {
            return ResponseEntity.ok(post);
        }
        return ResponseEntity.noContent().build();
	}

    @DeleteMapping("/posts/{num}")
    public ResponseEntity<Boolean> deletePost(
        @PathVariable("num") int num
    ) {
        boolean res = postService.deletePost(num);
        return ResponseEntity.ok(res);
    }
}
