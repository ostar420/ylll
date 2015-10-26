/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.mybatis.model;

import java.util.List;
import javax.validation.Valid;

/**
 *
 * @author YL
 */
public class CountryList {
    
    @Valid
    private List<Country> list ;

    /**
     * @return the list
     */
    public List<Country> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Country> list) {
        this.list = list;
    }
    
}
