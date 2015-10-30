package com.ylll.wx.service.impl;

import com.ylll.core.service.impl.BaseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.ylll.core.annotation.SystemLog;
import com.ylll.wx.mapper.UserInfoMapper;
import com.ylll.wx.model.UserInfo;
import com.ylll.wx.service.UserInfoService;
import java.util.Date;
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
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService {

    /**
     *
     */
    @Autowired
    protected UserInfoMapper userInfoMapper;

    @Override
    public List<UserInfo> selectByUserInfo(UserInfo userInfo, int page, int rows) throws Exception {
        Example example = new Example(UserInfo.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(userInfo.getName())) {
            criteria.andLike("name", "%" + userInfo.getName() + "%");
        }
        if (userInfo.getId() != null && !userInfo.getId().equals("")) {
            criteria.andEqualTo("id", userInfo.getId());
        }
        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);
    }

    @Override
    @SystemLog(module = "用户信息", methods = "添加")//凡需要处理业务逻辑的.都需要记录操作日志
    public int save(UserInfo entity) throws Exception {
        UserInfo t = selectByKey(entity.getId());
        if (t != null) {
            throw new Exception("user_id is exists.");
        }
        if(entity.getOpertime()==null) entity.setOpertime(new Date());
        return mapper.insert(entity);
    }

    @Override
    @SystemLog(module = "用户信息", methods = "删除")//凡需要处理业务逻辑的.都需要记录操作日志
    public int delete(Object key) throws Exception {
        return mapper.deleteByPrimaryKey(key);
    }

    @Override
    @SystemLog(module = "用户信息", methods = "更新")
    public int updateAll(UserInfo entity) throws Exception {
        if(entity.getOpertime()==null) entity.setOpertime(new Date());
        return mapper.updateByPrimaryKey(entity);
    }

    @Override
    @SystemLog(module = "用户信息", methods = "批量添加")
    public int batchInsertUser(List<UserInfo> list) throws Exception {
        return userInfoMapper.batchInsertUser(list);
    }

    @Override
    @SystemLog(module = "用户信息", methods = "批量删除")
    public int batchDeleteUser(List<String> list) throws Exception {
        return userInfoMapper.batchDeleteUser(list);
    }

}
