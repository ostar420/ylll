/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.util;

import com.ylll.core.conf.Service;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author YL
 */
public class ProjectSeqUtil {

    public static boolean sign(String project_seq) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

            String ip = Common.toIpAddr(request);
            System.out.println("ip:" + ip);
            return getProjectSeq(ip).equals(project_seq);
        }
        catch (Exception e) {
            return false;
        }
    }

    public static String getProjectSeq(String ip) throws Exception {
        String iSeq = Service.getProjectSeq();
        String seq = iSeq + ip;
        System.out.println("seq:" + seq);
        System.out.println("seq = " +  Coder.encryptBASE64(Coder.encryptMD5(seq.getBytes())));
        return Coder.encryptBASE64(Coder.encryptMD5(seq.getBytes()));
    }

}
