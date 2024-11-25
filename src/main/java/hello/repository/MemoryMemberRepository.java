package hello.repository;

import hello.domain.Member;
import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

  private static Map<Long, Member> store = new HashMap<>();
  private static long sequence = 0L;

  /**
   * @Override의 용도
   * 1. 의도 명시 : 메서드가 재정의된 것임을 명시적으로 보여줌.
   * 2. 컴파일러 오류 방지 : 부모 클래스나 인터페이스에 해당 메서드가 없으면 컴파일 에러를 발생시킴.
   * 3. 유지보수성 향상 : 부모 클래스의 메서드가 변경되었을 때 오류를 쉽게 감지 가능.
   */
  @Override
  public Member save(Member member) {
    member.setId(++sequence);
    store.put(member.getId(),member);
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    return Optional.ofNullable(store.get(id));
  }

  @Override
  public Optional<Member> findByName(String name) {
    return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
  }

  @Override
  public List<Member> findAll() {
    return new ArrayList<>(store.values());
  }

  public void clearStore() {
    store.clear();
  }
}
