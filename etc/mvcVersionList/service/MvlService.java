package com.spring.mvc.mvcVersionList.service;

import com.spring.mvc.mvcVersionList.domain.Mvl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MvlService {
    private final MvlRepository repository;

    public List<Mvl> findAllService(String sort){
        List<Mvl> mvlList = repository.findAll(sort);

        for (Mvl m : mvlList){
            String original = m.getName();
            StringBuilder markName = new StringBuilder(String.valueOf(original.charAt(0)));
            for (int i = 0; i < original.length() - 1; i++){
                markName.append("*");
            }

            m.setName(markName.toString());
        }
        return mvlList;
    }
}
