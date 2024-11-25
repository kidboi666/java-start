package hello.repository;

import hello.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
  
  // 1. Member 객체를 저장하는 메서드
  Member save(Member member);

  // 2. ID를 기반으로 Member 객체를 검색, Optional로 감싸서 반환 
  Optional<Member> findById(Long id);

  // 3. 이름을 기반으로 Member 객체를 검색, Optional로 감싸서 반환
  Optional<Member> findByName(String name);

  // 4. 모든 Member 객체를 List로 반환
  List<Member> findAll();
}
