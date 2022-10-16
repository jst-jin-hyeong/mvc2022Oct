package com.spring.mvc.servlet.chap02;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.server.Http2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

//클라이언트의 요청, 응답처리 클래스
//@Component //Bean 등록: 스프링컨테이너에 객체 생성을 위임
//핸들러맵핑이 이걸 잘 찾아주게 하는 방법은 Controller
@Controller // Component 이미 안에 포함되어있음
//스프링의 프론트컨트롤러가 이 클래스를 HandlerMapping으로 찾음
@Log4j2
public class BasicController {

    @Getter @Setter @ToString
    static class Order{
        private int num;
        private String goods;
        private int price;
    }

    @RequestMapping("/spring/about")
    public String about(){
//        System.out.println("/about 요청 발생!");
        log.trace("/about 요청 발생!"); //application.properties에서 설정하면 볼 수 있다.
        log.debug("/about 요청 발생!"); //
        log.info("/about 요청 발생!");
        log.warn("/about 요청 발생!");
        log.error("/about 요청 발생!");
//콘솔 출력 내용 --근데 왜 3가지만 나왔을까? trace, debug, info, warn, error는 어느정도 중요 | trace와 debug는 개발단계에서 보는 것!
//2022-10-15 11:46:00.624  INFO 23712 --- [nio-8181-exec-1] c.s.mvc.servlet.chap02.BasicController   : /about 요청 발생!
//2022-10-15 11:46:00.626  WARN 23712 --- [nio-8181-exec-1] c.s.mvc.servlet.chap02.BasicController   : /about 요청 발생!
//2022-10-15 11:46:00.627 ERROR 23712 --- [nio-8181-exec-1] c.s.mvc.servlet.chap02.BasicController   : /about 요청 발생!
        return "test";
    }

    @RequestMapping("/spring/hello")
    public String hello(){
        System.out.println("/hello 요청 발생!");
        return "redirect:/spring/about";
    }

//    클라이언트의 요청파라미터 읽기
//    @RequestMapping("/spring/join")
//    public String join(HttpServletRequest request){
//        String id = request.getParameter("account");
//        System.out.println("id: "+id);
//        return "";
//    }

//    @RequestMapping("/spring/join2")
//    public String join(String hobby){
//        System.out.println("hobby: "+hobby);
//        return "";
//    }

    @RequestMapping("/spring/join3")
    public String join(@RequestParam("h") String hobby){
        System.out.println("hobby= "+hobby);
        return "";
    }


    // 커맨드 객체로 파라미터 읽기
    // /spring/order?num=5566&goods=book&price=5000
    @RequestMapping("/spring/order")
    public String order(Order order) {
        System.out.println("order = " + order);
        return "";
    }

}
