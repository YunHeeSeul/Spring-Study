package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    //메모리를 Map에 저장
    private static Map<Long, Member> store = new HashMap<>();
    //sequence => 0, 1, 2,.. 키 값을 생성 해주는 애
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //sequence 값을 하나 올려주고 id 세팅할 것
        store.put(member.getId(), member); //그리고 store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //Optional로 감싸주면 null값이 반환되더라도 클라이언트에서 무언가 처리해줄 수 있음
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //getName()이 파라미터로 넘어온 name과 같은지 확인하고 같은 경우에만 필터링.
                .findAny(); //찾으면 반환
    }

    @Override
    public List<Member> findAll() { //Map인데 반환은 리스트로 되어있음
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

}
