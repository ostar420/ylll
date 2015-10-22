package com.ylll.core.mapper;

import com.ylll.core.model.Country;
import com.ylll.core.util.MyMapper;
import java.util.List;

/**
 *
 * @author YL
 */
public interface CountryMapper extends MyMapper<Country> {
    
    int batchInsertCountry(List<Country> list) throws Exception;
    
    int batchDeleteCountry(List<Integer> list) throws Exception;
}