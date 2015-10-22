package com.ylll.core.service;

import com.ylll.core.model.Country;

import java.util.List;

public interface CountryService extends BaseService<Country> {

    /**
     * 根据条件分页查询
     *
     * @param country
     * @param page
     * @param rows
     * @return
     * @throws java.lang.Exception
     */
    List<Country> selectByCountry(Country country, int page, int rows) throws Exception;

}
