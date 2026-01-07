package kr.hi.community.controller;

import kr.hi.community.model.dto.PostDTO;
import kr.hi.community.model.util.Criteria;
import kr.hi.community.model.util.CustomUser;
import kr.hi.community.model.util.PageMaker;
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

    @GetMapping("/post/list/{num}")
    public String postList(Model model,
        @PathVariable("num") int boardNum,
        // 기본 생성자를 이용하여 객체를 생성한 후
        // ? 뒤에 변수값이 필드와 일치하면 값을 수정
        Criteria cri
    ) {
        cri.setBoardNum(boardNum);
        // 서비스에게 게시판 번호에 맞는 게시글 목록을 가져오락로 요청
        // 가져온 게시글 목록을 list에 저장
        ArrayList<PostVO> list = postService.getPostList(cri);

        // 서비스에게 게시판 목록을 가져오라고 요청
        ArrayList<BoardVO> boardList = postService.getBoardList();

        // 페이지 정보 (검색어, 게시판, 타입)을 주면서 일치하는 게시글 수를 가져오라고 요청
        int totalCount = postService.getTotalCount(cri);
        // 페이지메이커를 생성
        PageMaker pm = new PageMaker(3, cri, totalCount);
        // 게시글 목록을 화면에 전송
        model.addAttribute("list", list);
        model.addAttribute("boardNum", boardNum);
        model.addAttribute("boardList", boardList);
        model.addAttribute("pm", pm);
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
            return "redirect:/post/list/" + post.getBoard();
        }
        return "redirect:/post/insert";
    }

    @PostMapping("/post/delete/{num}")
    public String postDeletePost(
            @PathVariable("num")
            int num,
            // 로그인한 회원 정보를 가져옴
            @AuthenticationPrincipal
            CustomUser currentUser
    ) {
        PostVO post = postService.selectPost(num);
        postService.deletePost(num, currentUser);
        return "redirect:/post/list/" + post.getPo_bo_num();
    }

    @GetMapping("/post/update/{num}")
    public String postUpdate(
            Model model,
            @PathVariable
            int num
    ) {
        PostVO post = postService.selectPost(num);
        model.addAttribute("post", post);
        return "/post/update";
    }

    @PostMapping("/post/update/{num}")
    public String postUpdatePost(
            @PathVariable("num")
            int num,
            PostDTO post,
            @AuthenticationPrincipal
            CustomUser currentUser
    ) {
        postService.updatePost(num, post, currentUser);
        return "redirect:/post/list/" + post.getBoard();
    }
}