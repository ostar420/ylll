package com.ylll.core.exception;

import com.ylll.core.conf.Service;
import com.ylll.core.model.MessagePO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 统一异常处理，有效地针对异步和非异步请求 不同异常会到不同页面 throw new ParameterException("XXXX") －－－－ >
 * error-parameter.jsp throw new SystemException("XXXX") －－－－ > error-System.jsp
 * throw new Exception("XXXX") －－－－ > error.jsp Status value 1001 业务异常返回 1001
 * 1002 参数异常返回 1003 权限异常返回 1000 其他异常返回
 */
public class MyExceptionHandler implements HandlerExceptionResolver {

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("ex", ex);
        //是否异步请求
        if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
                .getHeader("X-Requested-With") != null && request
                .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
            // 根据不同错误转向不同页面
            if (ex instanceof SystemException) {
                response.setStatus(1001);//业务异常返回 1001
                return new ModelAndView("exception/error-system", model);
            } else if (ex instanceof ParameterException) {
                response.setStatus(1002);//参数异常返回 1002
                return new ModelAndView("exception/error-parameter", model);
            } else if (ex instanceof AccessDeniedException) {
                response.setStatus(1003);//权限异常返回 1003
                return new ModelAndView("exception/error-permission", model);
            } else {
                response.setStatus(1000);//其他异常返回 1000
                return new ModelAndView("exception/error", model);
            }
        } else {

            MessagePO messagePO = new MessagePO(MessagePO.ERROR, "");
            try {
                if (ex instanceof SystemException) {
                    messagePO.setContent(Service.getMessageExceptionSystem());
                } else if (ex instanceof ParameterException) {
                    messagePO.setContent(Service.getMessageExceptionParameter());
                } else if (ex instanceof AccessDeniedException) {
                    messagePO.setContent(Service.getMessageExceptionAccessDenied());
                } else {
                    messagePO.setContent(Service.getMessageExceptionSystem());
                }
                response.setCharacterEncoding("utf-8");
                messagePO.setObj(ex.getMessage());
                PrintWriter writer = response.getWriter();
                writer.write(messagePO.toString());
                writer.flush();
            }
            catch (IOException e) {
                model.put("ex", e);
                return new ModelAndView("exception/error", model);
            }
            return new ModelAndView();
        }
    }
}
