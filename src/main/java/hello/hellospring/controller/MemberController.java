package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //home.html을 열어보면 members/new라는 url로 이동하므로
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){ //MemberForm을 만들고
        //Member 생성
        Member member = new Member();
        member.setName(form.getName());

        //생성한 멤버 넘김
        memberService.join(member);

        return "redirect:/"; //회원가입이 끝났으니 홈화면으로 보내버리기
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers(); //findMembers()를 통해 모든 멤버들을 다 가져와서 리스트 형태로 저장
        model.addAttribute("members", members);
        return "members/memberList";

    }

}
