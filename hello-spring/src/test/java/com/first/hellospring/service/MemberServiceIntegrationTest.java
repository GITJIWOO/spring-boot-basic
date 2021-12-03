package com.first.hellospring.service;

import com.first.hellospring.domain.Member;
import com.first.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행한다.
@Transactional // 테스트를 실행 후 DB에 들어가는 데이터를 자동으로 지워서 다음 테스트에 영향을 주지 않는다.
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    // 한국 회사라면 Test에선 한글을 써도 괜찮다.
    @Test
    // @Commit // 테스트 후 DB에 바로 커밋을 해준다.
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring123");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        /*
        try {
            memberService.join(member2);
            fail();
        } catch(IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */
        // then
    }

}