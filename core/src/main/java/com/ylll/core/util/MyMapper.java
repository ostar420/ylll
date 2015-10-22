package com.ylll.core.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 * 可自定义其他的方法
 * @param <T>
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
