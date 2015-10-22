package com.ylll.core.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通用接口
 * @param <T>
 */
@Service
public interface BaseService<T> {

    /**
     *
     * @param key
     * @return
     * @throws Exception
     */
    T selectByKey(Object key) throws Exception;

    /**
     *
     * @param entity
     * @return
     * @throws Exception
     */
    int save(T entity) throws Exception;

    /**
     *
     * @param key
     * @return
     * @throws Exception
     */
    int delete(Object key) throws Exception;

    /**
     *
     * @param entity
     * @return
     * @throws Exception
     */
    int updateAll(T entity) throws Exception;

    /**
     *
     * @param entity
     * @return
     * @throws Exception
     */
    int updateNotNull(T entity) throws Exception;

    /**
     *
     * @param example
     * @return
     * @throws Exception
     */
    List<T> selectByExample(Object example) throws Exception;

    //TODO 其他...
}
