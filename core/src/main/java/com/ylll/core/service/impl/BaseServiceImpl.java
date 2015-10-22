package com.ylll.core.service.impl;

import com.ylll.core.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 *
 * @author YL
 * @param <T>
 */
@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    /**
     *
     */
    @Autowired
    protected Mapper<T> mapper;

    /**
     *
     * @param key
     * @return
     * @throws Exception
     */
    @Override
    public T selectByKey(Object key) throws Exception {
        return mapper.selectByPrimaryKey(key);
    }

    /**
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @Override
    public int save(T entity) throws Exception {
        return mapper.insert(entity);
    }

    /**
     *
     * @param key
     * @return
     * @throws Exception
     */
    @Override
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
    public int updateAll(T entity) throws Exception {
        return mapper.updateByPrimaryKey(entity);
    }

    /**
     *
     * @param entity
     * @return
     * @throws Exception
     */
    @Override
    public int updateNotNull(T entity) throws Exception {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    /**
     *
     * @param example
     * @return
     * @throws Exception
     */
    @Override
    public List<T> selectByExample(Object example) throws Exception {
        return mapper.selectByExample(example);
    }

    //TODO 其他...
}
