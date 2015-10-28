/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.util;

import com.ylll.core.conf.Service;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author YL
 */
public class ProjectSeqUtil {
    private static final Logger logger = LoggerFactory.getLogger(ProjectSeqUtil.class);

    /**
     *
     * @param project_seq
     * @return
     */
    public static boolean sign(String project_seq) {
        if(project_seq == null) return false;
        project_seq = project_seq.trim();
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            String ip = Common.toIpAddr(request);
            logger.debug("ip:{}" , ip);
            logger.debug("user pro_seq :{} " , project_seq );
            boolean flag = getProjectSeq(ip).equals(project_seq);
            logger.debug("project_seq vali result:{} " , flag );
            return flag;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     *
     * @param ip
     * @return
     * @throws Exception
     */
    public static String getProjectSeq(String ip) throws Exception {
        String iSeq = Service.getProjectSeq();
        String seq = iSeq + ip;
        logger.debug("seq:{}" , seq);
        String pro_seq = Coder.encryptBASE64(Coder.encryptMD5(seq.getBytes())).trim();
        logger.debug("web pro_seq :{} " , pro_seq );
        return pro_seq;
    }

}
