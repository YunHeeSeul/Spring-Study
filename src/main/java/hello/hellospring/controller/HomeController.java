package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    // /는 그냥 도메인 첫번째, localhost8080으로 들어오면 이 부분이 호출됨
    public String home() {
        return "home"; //그리고 home.html이 호출될 것
    }
}
