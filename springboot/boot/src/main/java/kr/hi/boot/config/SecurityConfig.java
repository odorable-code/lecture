package kr.hi.boot.config;

import kr.hi.boot.model.util.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
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
                        //.loginPage("/login")  // 커스텀 로그인 페이지 설정
                        .permitAll()           // 로그인 페이지는 접근 허용
                        .loginProcessingUrl("/login")//
                        .defaultSuccessUrl("/")
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