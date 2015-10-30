package com.ylll.core.controller;

import com.ylll.core.service.PdfService;
import com.ylll.core.util.Common;
import java.io.File;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author YL
 */
@Controller
@RequestMapping(value = "/pdf")
public class PdfController {
    
    private final String read_pdf_path = "system"+Common.FILE_SEPARATOR+"base"+Common.FILE_SEPARATOR+"pdf";
    
    @Autowired
    private PdfService pdfService;
    
    /**
     * 
     * @param pdfName
     * @return 
     * @throws java.lang.Exception 
     */
    @RequestMapping({"readpdf/{pdfName}"})
    public ModelAndView readpdf(@PathVariable("pdfName") String pdfName) throws Exception {
        ModelAndView modelAndView = new ModelAndView(read_pdf_path);
        pdfService.getPdfPath(pdfName);
        modelAndView.addObject("pdfName", pdfName );
        return modelAndView;
    }
    
    /**
     * 返回可读取pdf
     * @param pdfName
     * @param request
     * @return
     * @throws Exception 
     */
    @RequestMapping({"getpdf/{pdfName}"})
    @ResponseBody
    public ResponseEntity<byte[]> getpdf(@PathVariable("pdfName") String pdfName, HttpServletRequest request) throws  Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/pdf");
        headers.setContentDispositionFormData("attachment", pdfName+".pdf");  
        String filepath =  pdfService.getPdfPath(pdfName);
        String realPathDir = request.getSession().getServletContext().getRealPath(filepath);
        File file = new File(realPathDir);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

}
