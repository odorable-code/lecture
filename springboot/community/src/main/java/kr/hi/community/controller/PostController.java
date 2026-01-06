package kr.hi.community.controller;

import kr.hi.community.model.dto.PostDTO;
import kr.hi.community.model.util.CustomUser;
import kr.hi.community.model.vo.BoardVO;
import kr.hi.community.model.vo.PostVO;
import kr.hi.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/post/list")
    public String postList(Model model) {
        // 서비스에게 게시글 목록을 가져오락로 요청
        // 가져온 게시글 목록을 list에 저장
        ArrayList<PostVO> list = postService.getPostList();
        // 게시글 목록을 화면에 전송
        model.addAttribute("list", list);
        return "/post/list"; // post폴더에 list.html을 화면으로 보내줌
    }

    @GetMapping("/post/detail/{num}")
    public String postDetail(
            Model model,
            @PathVariable("num")
            int po_num
    ) {
        // 게시글 번호를 이용해서 조회수 증가
        postService.updateView(po_num);
        // 게시글 번호를 이용해서 게시글 가져오기
        // 게시글 번호(기본키)를 이용하여 게시글을 조회하면? => 최대 1개
        PostVO post = postService.selectPost(po_num);
        // 화면으로 게시글 전송
        model.addAttribute("post", post);
        return "/post/detail";
    }

    @GetMapping("/post/insert")
    public String postInsert(Model model) {
        ArrayList<BoardVO> boards = postService.getBoardList();
        model.addAttribute("boards", boards);
        return "/post/insert";
    }

    @PostMapping("/post/insert")
    public String postInsertPost(Model model, PostDTO post, @AuthenticationPrincipal CustomUser currentUser) {
        boolean result = postService.insertPost(post, currentUser);
        if (result) {
            return "redirect:/post/list";
        }
        return "redirect:/post/insert";
    }
}