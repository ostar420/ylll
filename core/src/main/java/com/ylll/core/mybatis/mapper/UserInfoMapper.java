package com.ylll.core.mybatis.mapper;

import com.ylll.core.mybatis.model.UserInfo;
import com.ylll.core.util.MyMapper;
import java.util.List;

/**
 *
 * @author YL
 */
public interface UserInfoMapper extends MyMapper<UserInfo> {
    
    /**
     *
     * @param list
     * @return
     * @throws Exception
     */
    int batchInsertUser(List<UserInfo> list) throws Exception;
    
    /**
     *
     * @param list
     * @return
     * @throws Exception
     */
    int batchDeleteUser(List<String> list) throws Exception;
}