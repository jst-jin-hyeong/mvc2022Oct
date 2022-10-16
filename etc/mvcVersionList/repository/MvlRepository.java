package com.spring.mvc.mvcVersionList.repository;

import com.spring.mvc.mvcVersionList.domain.Mvl;

import java.util.List;

public interface MvlRepository {
    boolean save(Mvl mvl);

    List<Mvl> findAll(String sort);

    Mvl findOne(int serialNum);

    boolean remove(int serialNum);
}
