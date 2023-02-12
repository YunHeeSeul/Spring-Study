package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();

    @Test //save 기능 테스트
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        //Optional에서는 get으로 값을 꺼낼 수 있음
        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, result); // junit assertions => result와 member 값이 같다면 별다른 출력 없이 초록불이, 다르면 빨간불이 들어옴
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result); //org assertions 주로 이걸 사용.
    }
}
