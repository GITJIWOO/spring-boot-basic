package com.first.hellospring.service;

import com.first.hellospring.domain.Member;
import com.first.hellospring.repository.MemberRepository;
import com.first.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    // DI(Dependency Injection) : 의존성 주입
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        // 중복 회원 X
        validataDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // 중복 회원 검증 메서드
    private void validataDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
