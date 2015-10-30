package com.ylll.wx.mapper;

import com.ylll.wx.model.Country;
import com.ylll.core.util.MyMapper;
import java.util.List;

/**
 *
 * @author YL
 */
public interface CountryMapper extends MyMapper<Country> {
    
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