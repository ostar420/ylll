package com.ylll.core.service;

import com.ylll.core.mybatis.model.Country;
import com.ylll.core.mybatis.model.UserInfo;

import java.util.List;

/**
 *
 * @author YL
 */
public interface UserInfoService extends BaseService<UserInfo> {

    /**
     * 根据条件分页查询
     *
     * @param userInfo
     * @param page
     * @param rows
     * @return
     * @throws java.lang.Exception
     */
    List<UserInfo> selectByUserInfo(UserInfo userInfo, int page, int rows) throws Exception;
    
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
