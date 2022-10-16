package com.spring.mvc.score.repository;

import com.spring.mvc.score.domain.Score;

import java.util.List;

//점수 저장소라는 녀석인데
//얘 책임은 뭐냐:  성적정보를 저장하고 조회하고 삭제하는 일을 수행

public interface ScoreRepository{

    // 점수 저장
    boolean save(Score score);

    // 전체 점수 정보 조회
    List<Score> findAll(String sort); //sort에 담아서 정렬 어떻게 할 지 알려줘

    // 개별 점수 조회
    Score findOne(int stuNum); //1개니까 리스트가 아니라 score 객체 하나만 주는 거지

    // 점수 정보 삭제
    boolean remove(int stuNum); //학번 하나만 던지니까

}
