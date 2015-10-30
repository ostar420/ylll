package com.ylll.wx.service;

import com.ylll.core.service.BaseService;
import com.ylll.wx.model.Country;

import java.util.List;

/**
 *
 * @author YL
 */
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
    
    /**
     *
     * @param list
     * @return
     * @throws Exception
     */
    int batchInsertCountry(List<Country> list) throws Exception;

    /**
     *
     * @param list
     * @return
     * @throws Exception
     */
    int batchDeleteCountry(List<Integer> list) throws Exception;

}
