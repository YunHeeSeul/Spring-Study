package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.processing.Generated;

@Controller //스프링은 notation을 적어줘야 함
public class HelloController {
    //웹어플리케이션에서 /hello가 들어오면 이 메소드를 호출해줌
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!!");
        return "hello";
    }
}
