package hello.service;

import java.util.Optional;

import hello.domain.Member;
import hello.repository.MemberRepository;
import hello.repository.MemoryMemberRepository;

public class MemberService {
  
  private final MemberRepository memberRepository = new MemoryMemberRepository();
  
  /**
   * 회원 가입
   */
  public Long join(Member member) {
    // 같은 이름이 있는 중복 회원x
    Optional<Member> result = memberRepository.findByName(member.getName());
    result.ifPresent(m -> {
      throw new IllegalStateException("이미 존재하는 회원입니다.");
    });
    memberRepository.save(member);
    return member.getId();
  }
}