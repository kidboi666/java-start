package hello.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import hello.domain.Member;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
  
  MemoryMemberRepository repository = new MemoryMemberRepository();

  /**
   * 각 테스트 케이스는 독립적으로 이루어진다. 순서에 의존성이 있어선 안된다.
   * 각 테스트가 끝난뒤 메모리를 비우는 코드를 작성하여 테스트 간 충돌을 방지
   */
  @AfterEach
  public void afterEach() {
    repository.clearStore();
  }

  @Test
  public void save() {
    Member member = new Member();
    member.setName("spring");

    repository.save(member);

    Member result = repository.findById(member.getId()).get();
    assertThat(member).isEqualTo(result);
  }

  @Test
  public void findByName() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    Member result = repository.findByName("spring1").get();

    assertThat(result).isEqualTo(member1);
  }

  @Test
  public void findAll() {
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);

    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);

    List<Member> result = repository.findAll();

    assertThat(result.size()).isEqualTo(2);


  }
}
