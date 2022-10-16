package com.spring.mvc.mvcVersionList.controller;

import com.spring.mvc.mvcVersionList.domain.Mvl;
import com.spring.mvc.mvcVersionList.service.MvlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@Log4j2
@RequiredArgsConstructor
public class MvlController {
    private final MvlRepository repository;
    private final MvlService service;

    @GetMapping("/mvl/list")
    public String list(
            @RequestParam(defaultValue = "num") String sort
            , Model model){
        log.info("/mvl/list GET 요청!! - param1: {}", sort);
        List<Mvl> mvlList = service.findAllService(sort);
        model.addAttribute("mvls", mvlList);
        return "mvl/list";
    }

    @PostMapping("/mvl/register")
    public String register(Mvl mvl){
        log.info("/mvl/register POST! - " + mvl);

        return repository.save(mvl) ? "redirect:/mvl/list" : "redirect:/";
    }

    @GetMapping("/mvl/detail")
    public String detail(int serialNum, Model model){
        log.info("/mvl/detail GET - param1: {}", serialNum);
        Mvl mvl = repository.findOne(serialNum);
        model.addAttribute(m, mvl);

        return "mvl/detail";
    }


}
