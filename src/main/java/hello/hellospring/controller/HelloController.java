package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.processing.Generated;

@Controller //스프링은 notation을 적어줘야 함
public class HelloController {
    //웹어플리케이션에서 /hello가 들어오면 이 메소드를 호출해줌
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!!");
        return "hello"; //templates로 넘어감
    }

    @GetMapping("hello-mvc")
    //helloMvc라는 메소드를 만들고 이번엔 웹에서 파라미터를 받을 것=>@RequestParam("") String 형태의 name을 받아서 모델에 담아주면 이걸 뷰에서 사용
    public String helloMvc(@RequestParam("name") String name, Model model){
        //파라미터로 넘어온 name을 넘겨줄 것. "name"이 키고 name이 값
        model.addAttribute("name", name);
        return "hello-template"; //templates로 넘어감
    }

    @GetMapping("hello-string")
    @ResponseBody //@ResponseBody는 html의 body태그를 얘기하는 것이 아니라 http에 header부와 body가 있는데 거기서 body부에 내용을 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello "+ name; //=>name을 spring이라 하면 결과는 "hello spring"이 나옴
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) { //Hello라는 객체 하나 생성
        Hello hello = new Hello();
        hello.setName(name); //파라미터로 넘어온 name을 넣고
        return hello; //객체를 리턴해줌.
    }
    static class Hello { //static 클래스로 만들면 HelloController 클래스 안에서 HelloController.Hello 이런 식으로 사용할 수 있음
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
