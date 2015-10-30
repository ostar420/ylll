package com.ylll.wx.mapper;

import com.ylll.wx.model.UserInfo;
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