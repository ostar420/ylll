package com.ylll.wx.service.impl;

import com.ylll.core.service.impl.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.ylll.core.annotation.SystemLog;
import com.ylll.wx.mapper.CountryMapper;
import com.ylll.wx.model.Country;
import com.ylll.wx.service.CountryService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author YL
 */
@Service
public class CountryServiceImpl extends BaseServiceImpl<Country> implements CountryService {
    
    /**
     *
     */
    @Autowired
    protected CountryMapper countryMapper;
    @Override
    //@SystemLog(module = "测试模块", methods = "分页查询Service")//凡需要处理业务逻辑的.都需要记录操作日志
    public List<Country> selectByCountry(Country country, int page, int rows) throws Exception {
        Example example = new Example(Country.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(country.getCountryname())) {
            criteria.andLike("countryname", "%" + country.getCountryname() + "%");
        }
        if (StringUtil.isNotEmpty(country.getCountrycode())) {
            criteria.andLike("countrycode", "%" + country.getCountrycode() + "%");
        }
        if (country.getId() != null) {
            criteria.andEqualTo("id", country.getId());
        }
        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);
    }

    /**
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @Override
    @SystemLog(module = "测试模块", methods = "添加Service")//凡需要处理业务逻辑的.都需要记录操作日志
    public int save(Country entity) throws Exception {
        return mapper.insert(entity);
    }

    /**
     *
     * @param key
     * @return
     * @throws Exception
     */
    @Override
    @SystemLog(module = "测试模块", methods = "删除Service")//凡需要处理业务逻辑的.都需要记录操作日志
    public int delete(Object key) throws Exception {
        return mapper.deleteByPrimaryKey(key);
    }

    /**
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @Override
    @SystemLog(module = "测试模块", methods = "更新Service")
    public int updateAll(Country entity) throws Exception {
        return mapper.updateByPrimaryKey(entity);
    }

    /**
     *
     * @param list
     * @return
     * @throws Exception
     */
    @Override
    @SystemLog(module = "测试模块", methods = "批量添加")
    public int batchInsertCountry(List<Country> list) throws Exception {
      return   countryMapper.batchInsertCountry(list);
    }

    /**
     *
     * @param list
     * @return
     * @throws Exception
     */
    @Override
     @SystemLog(module = "测试模块", methods = "批量删除")
    public int batchDeleteCountry(List<Integer> list) throws Exception {
        return   countryMapper.batchDeleteCountry(list);
    }
    
  
}
