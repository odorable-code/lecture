package kr.hi.boot.config;

import kr.hi.boot.model.util.UserRole;
import kr.hi.boot.service.MemberDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Autowired
    MemberDetailService memberDetailService;
    //암호화 하는 클래스
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf ->csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        //url이 /post/insert/* 이면 로그인한 회원중 역할이 USER인 회원만 접근
                        .requestMatchers("/post/insert").hasAuthority(UserRole.USER.name())
                        //url이 /admin/으로 시작하는 url들은 로그인한 회원중 역할이 admin인 회원만 접근
                        .requestMatchers("/admin/**").hasAnyAuthority(UserRole.ADMIN.name())
                        //그 외 url은 아무나 접근 가능
                        .anyRequest().permitAll()  // 그 외 요청은 인증 필요
                )
                .formLogin((form) -> form
                        .loginPage("/login")  // 커스텀 로그인 페이지 설정
                        .permitAll()           // 로그인 페이지는 접근 허용
                        .loginProcessingUrl("/login")//
                        .defaultSuccessUrl("/")
                )
                .rememberMe(rm-> rm
                        //자동로그인이 체크되어 있으면 memberDetailService를 이용해서 로그인 진행
                        .userDetailsService(memberDetailService)
                        //쿠키에 저장할 토큰을 생성할 때 활용할 문자열
                        //이 문자열이 바뀌면 이전에 있던 토큰이 무효화 되어 자동 로그인 취소
                        //key에 들어가는 문자열은 노출되면 안됨.
                        //application.properties에 작성해서 관리해야함.
                        .key("abc123")
                        //쿠키 이름
                        .rememberMeCookieName("LC")
                        //쿠키 유효시간(단위 초).
                        .tokenValiditySeconds(60*60*24*7)//7일
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true)
                        .permitAll());  // 로그아웃도 모두 접근 가능
        return http.build();
    }
}