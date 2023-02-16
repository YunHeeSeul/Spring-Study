package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test //save 기능 테스트
    public void save(){
        Member member = new Member(); //Memeber 선언
        member.setName("spring"); //이름(spring) 세팅

        repository.save(member); //repository에 저장해보고

        //Optional에서는 get으로 값을 꺼낼 수 있음
        Member result = repository.findById(member.getId()).get();
        //Assertions.assertEquals(member, result); // junit assertions => result와 member 값이 같다면 별다른 출력 없이 초록불이, 다르면 빨간불이 들어옴
        assertThat(member).isEqualTo(result); //org assertions 주로 이걸 사용.
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get(); //spring1 찾아서 result로 받기

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
