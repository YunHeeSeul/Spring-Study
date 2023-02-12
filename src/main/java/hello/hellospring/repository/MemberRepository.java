package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //회원을 저장
    //Optional => java8에 들어간 기능. findById나 findByName을 해서 가져오는데 null일 수도 있음. null을 처리할 떄 Optional로 감싸서 처리하는 것을 선호함
    Optional<Member> findById(Long id); //id로 회원 찾아옴
    Optional<Member> findByName(String name); //이름으로 회원 찾아옴
    List<Member> finalAll(); //지금까지 저장된 모든 회원리스트 반환
}
