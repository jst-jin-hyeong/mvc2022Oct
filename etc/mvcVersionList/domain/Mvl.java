package com.spring.mvc.mvcVersionList.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@AllArgsConstructor
public class Mvl {
    private String account;
    private String pw;
    private String name;
    private static int seq;
    private int serialNum;

    public Mvl() {
        this.serialNum = ++seq;
    }
}
