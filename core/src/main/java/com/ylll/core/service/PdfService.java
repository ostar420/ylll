package com.ylll.core.service;

/**
 *
 * @author YL
 */
public interface PdfService  {
   /**
    * 
    * @param pdf pdf无后缀文件名 不含.pdf
    * @return
    * @throws Exception 
    */
    String getPdfPath(String pdf) throws Exception;
}
