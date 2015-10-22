package com.ylll.core.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通用接口
 */
@Service
public interface BaseService<T> {

    T selectByKey(Object key) throws Exception;

    int save(T entity) throws Exception;

    int delete(Object key) throws Exception;

    int updateAll(T entity) throws Exception;

    int updateNotNull(T entity) throws Exception;

    List<T> selectByExample(Object example) throws Exception;

    //TODO 其他...
}
