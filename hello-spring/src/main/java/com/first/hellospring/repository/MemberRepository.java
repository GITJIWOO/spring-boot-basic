package com.first.hellospring.repository;

import com.first.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    // Optional
    // null로 반환된다면 null 대신 Optional로 감싸서 반환한다.
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}
