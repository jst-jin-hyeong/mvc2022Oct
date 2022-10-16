package com.spring.mvc.score.controller;

//import com.spring.webmvc.springmvc.chap02.domain.Score;
//import com.spring.webmvc.springmvc.chap02.repository.ScoreMapper;
//import com.spring.webmvc.springmvc.chap02.repository.ScoreRepository;
import com.spring.mvc.score.domain.Score;
import com.spring.mvc.score.repository.ScoreMapper;
import com.spring.mvc.score.repository.ScoreRepository;
import com.spring.mvc.score.service.ScoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor // final 필드 초기화 생성자를 만듦
public class ScoreController {

    //    private final ScoreRepository repository;
//    private final ScoreMapper repository;


    //    의존관계
    private final ScoreMapper repository;
    private final ScoreService service;

//    public ScoreController(ScoreRepository repository) {
//        this.repository = repository;
//    }


    // 점수 등록 및 조회 화면 열기 요청 -> 데이터베이스에 접근하는 클래스에 의존할 수 밖에 없다.
    @GetMapping("/score/list")
    public String list(
            @RequestParam(defaultValue = "num") String sort
            , Model model) {
        log.info("/score/list GET 요청!! - param1 : {}", sort);
        List<Score> scoreList = service.findAllService(sort);
// jsp에게 점수 정보 리스트를 전달해야 함.
//        List<Score> scoreList = repository.findAll(sort);
//
//        // 이름 마킹 처리
//        for (Score s : scoreList) {
//            String original = s.getName();
//            StringBuilder markName = new StringBuilder(String.valueOf(original.charAt(0)));
//            for (int i = 0; i < original.length() - 1; i++) {
//                markName.append("*");
//            }
//            s.setName(markName.toString());
//        }

        model.addAttribute("scores", scoreList);
//        /WEB-INF/score/list.jsp 포워딩해서 열어주는 코드
        return "score/list";
    }

    // 점수 신규 등록 요청
    @PostMapping("/score/register")
    public String register(Score score) {
        score.calcTotalAndAvg();
        score.calcGrade();
        log.info("/score/register POST! - " + score);

        return repository.save(score) ? "redirect:/score/list" : "redirect:/";
    }

    // 점수 삭제 요청
    @RequestMapping("/score/delete")
    public String delete(@RequestParam("stuNum") int sn) {
        log.info("/score/delete GET - param1: {}", sn);
        return repository.remove(sn) ? "redirect:/score/list" : "redirect:/";
    }

    // 점수 상세 조회 요청
// 점수 상세 조회 요청
    @GetMapping("/score/detail")
    public String detail(int stuNum, Model model) {
        log.info("/score/detail GET - param1: {}", stuNum);
        Score score = repository.findOne(stuNum);
        model.addAttribute("s", score);

        return "score/detail";
    }

}