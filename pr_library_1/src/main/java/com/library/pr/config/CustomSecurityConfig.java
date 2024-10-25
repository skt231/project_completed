package com.library.pr.config;

import com.library.pr.security.handler.Custom403Handler;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Log4j2
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        log.info("------------------configure------------------------");

        http.formLogin().loginPage("/member/login")
                .defaultSuccessUrl("/book/home",true);

        http.csrf().disable();

        http.logout()
                .logoutUrl("/member/logout") // 로그아웃 URL 지정
                .invalidateHttpSession(true) // 세션 무효화
                .clearAuthentication(true)   // 인증 정보 삭제
                .deleteCookies("JSESSIONID") // 세션 쿠키 삭제
                .logoutSuccessUrl("/book/home"); // 로그아웃 성공 후 이동할 URL

        http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());//403
        return http.build();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new Custom403Handler();
    }
//정적 자원 제외
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {

        log.info("------------web configure-------------------");

        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());

    }
}
