package com.ylll.core.service;

import com.ylll.core.model.Log;
import java.util.List;

public interface LogService extends BaseService<Log> {
    /**
     * 根据条件分页查询
     *
     * @param log
     * @param page
     * @param rows
     * @return
     * @throws java.lang.Exception
     */
    List<Log> selectByLog(Log log, int page, int rows) throws Exception;
}
