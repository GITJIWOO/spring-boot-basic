package com.first.hellospring;

import com.first.hellospring.repository.MemberRepository;
import com.first.hellospring.repository.MemoryMemberRepository;
import com.first.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // 자바 코드로 Spring Bean 의존성 주입 하는 법
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
