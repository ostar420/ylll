package com.ylll.core.service.impl;

import com.ylll.core.exception.PermissionException;
import com.ylll.core.service.PdfService;
import com.ylll.core.util.Common;
import org.springframework.stereotype.Service;

/**
 *
 * @author YL
 */
@Service
public class PdfServiceImpl implements PdfService {
    
    private final String pdf_dir = Common.UPLOAD_PATH   +Common.FILE_SEPARATOR  +"pdf" +Common.FILE_SEPARATOR;

    /**
     * 过滤权限 获取pdf 文件路径
     * @param pdf 不含后缀pdf 文件名
     * @return
     * @throws Exception 
     */
    @Override
    public String getPdfPath(String pdf) throws Exception {
        
        if(!getPdfPermission(pdf)){
            throw  new PermissionException("has no permission for the file:"+pdf);
        } 
        
        
        return pdf_dir+pdf+".pdf";
    }
    
    /**
     * 判断用户访问 pdf 权限
     * @param pdf
     * @return 
     */
    private boolean getPdfPermission(String pdf){
        boolean flag = false;
        //这里可以通过表配置 文件权限
        //这里测试
        if(pdf != null && pdf.equals("rates"))
            flag = true;
        
        return flag;
    }
    
    
        
}
