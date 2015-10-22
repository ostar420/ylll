package com.ylll.core.service.impl;

import com.ylll.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected Mapper<T> mapper;

    @Override
    public T selectByKey(Object key) throws Exception {
        return mapper.selectByPrimaryKey(key);
    }

    @Override
    public int save(T entity) throws Exception {
        return mapper.insert(entity);
    }

    @Override
    public int delete(Object key) throws Exception {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    public int updateAll(T entity) throws Exception {
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(T entity) throws Exception {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    @Override
    public List<T> selectByExample(Object example) throws Exception {
        return mapper.selectByExample(example);
    }

    //TODO 其他...
}
