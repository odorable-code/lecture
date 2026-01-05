package kr.hi.community.controller;

import kr.hi.community.model.dto.MemberDTO;
import kr.hi.community.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    // 객체를 생성해서 연결 단, 빈(bean)에 등록된 클래스, 인터페이스만
    // @Bean, @Service, @Repository등
    @Autowired
    MemberService memberService;
    /* Get: URL을 직접 입력하거나, 링크를 클릭해서 이동했을 때 대부분 Get
     * Post: 값을 입력하여 중요한 정보를 전송할 때 (form 태그 + method=post)
     * */
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(
            /* 화면이 보낸 회원 정보를 받아옴 */
        MemberDTO member
    ) {
        boolean result = memberService.signup(member);

        if (result) {
        /* - redirect는 PostMapping일 때 주로 사용
         * - 지정된 url를 바꿔줌 (여기서는 메인페이지(/))
         */
            return "redirect:/";
        } else {
            return "redirect:/signup";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}