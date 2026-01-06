package kr.hi.community.controller;

import kr.hi.community.model.vo.BoardVO;
import kr.hi.community.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    PostService postService;

    @GetMapping("/board/list") //실제 /admin/board/list
    public String boardList(Model model) {
        ArrayList<BoardVO> list = postService.getBoardList();
        model.addAttribute("list", list);
        return "/board/list";
    }

    @PostMapping("/board/insert")
    public String boardInsert(Model model, String bo_name) {
        if (bo_name.isEmpty()) { return "redirect:/admin/board/list"; }

        ArrayList<BoardVO> list = postService.getBoardList();
        for (BoardVO board : list) {
            if (board.getBo_name().equals(bo_name)) {
                return "redirect:/admin/board/list";
            }
        }
        postService.insertBoard(bo_name);
        return "redirect:/admin/board/list";
    }

    @PostMapping("/board/delete/{num}")
    public String boardDelete(
            Model model,
            @PathVariable("num")
            int num
    ) {
        System.out.println(num);
        postService.deleteBoard(num);
        return "redirect:/admin/board/list";
    }

    @PostMapping("/board/update/{num}")
    public String boardUpdate(
            @PathVariable("num")
            int num,
            String name
    ) {
        postService.updateBoard(num, name);
        return "redirect:/admin/board/list";
    }
}