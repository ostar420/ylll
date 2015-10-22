package com.ylll.core.service.impl;

import com.github.pagehelper.PageHelper;
import com.ylll.core.model.Log;
import com.ylll.core.service.LogService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 *
 * @author YL
 */
@Service
public class LogServiceImpl extends BaseServiceImpl<Log> implements LogService {
    
    @Override
    public List<Log> selectByLog(Log log, int page, int rows) throws Exception{
        Example example = new Example(Log.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(log.getModule())) {
            criteria.andLike("module", "%" + log.getModule() + "%");
        }
        if (StringUtil.isNotEmpty(log.getUsername())) {
            criteria.andLike("username", "%" + log.getUsername() + "%");
        }
        if (StringUtil.isNotEmpty(log.getUserip())) {
            criteria.andLike("userip", "%" + log.getUserip() + "%");
        }
        if (StringUtil.isNotEmpty(log.getAction())) {
            criteria.andLike("action", "%" + log.getAction() + "%");
        }
        if (log.getId() != null) {
            criteria.andEqualTo("id", log.getId());
        }
        //分页查询
        PageHelper.startPage(page, rows);
        return selectByExample(example);   
    }
    
    
        
}
