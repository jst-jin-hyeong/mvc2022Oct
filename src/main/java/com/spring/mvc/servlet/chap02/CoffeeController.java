package com.spring.mvc.servlet.chap02;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@Log4j2
public class CoffeeController {

//    커피 주문 폼 화면 열기 요청

    @GetMapping("/coffee/form")
    public String form(){
        log.info("/coffee/form GET 요청 발생!");
        return "coffee/coffee-form";
    }

    // 커피 주문 처리 요청
//    @PostMapping("/coffee/result" )
//    public String result(String menu, int price, HttpServletRequest request){
//        log.info("/coffee/result POST 요청 발생! - menu: {}, price: {}", menu, price);
//        request.setAttribute("m", menu); //request에 담기면 1회성, session에 담기면 session에
//        request.setAttribute("p", price);
//        return "coffee/coffee-result";
//    }
    @PostMapping("/coffee/result" )
    public String result(String menu, int price, Model model){
        log.info("/coffee/result POST 요청 발생! - menu: {}, price: {}", menu, price);

        switch(menu){
            case "americano":
                menu = "아메리카노";
                break;
            case "cafeLatte":
                menu = "카페라떼";
                break;
            case "macchiato":
                menu = "마키아로우";
                break;
        }

        model.addAttribute("m", menu); //request에 담기면 1회성, session에 담기면 session에
        model.addAttribute("p", price);
        return "coffee/coffee-result";
    }
}