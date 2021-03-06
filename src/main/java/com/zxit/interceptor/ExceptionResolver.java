package com.zxit.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * @author xnf
 *         异常集中处理
 */
@Deprecated
public class ExceptionResolver extends SimpleMappingExceptionResolver {

    //记录日志
    private Logger m_log = Logger.getLogger("com.zxit.interceptor.ExceptionResolver");

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request,
                                              HttpServletResponse response, Object handler, Exception ex) {
        //获取错误代码
        String viewName = determineViewName(ex, request);
        if (viewName != null) {// JSP格式返回
            if (!(request.getHeader("accept").indexOf("application/json") > -1 || (request
                    .getHeader("X-Requested-With") != null && request
                    .getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
                // 如果不是异步请求
                Integer statusCode = determineStatusCode(request, viewName);
                if (statusCode != null) {
                    applyStatusCodeIfPossible(request, response, statusCode);
                }
                //记录日志
                m_log.error(ex);
                request.setAttribute("ex", ex);
                return getModelAndView(viewName + "/" + statusCode, ex, request);
            } else {//ajax异步异常输出！
                try {
                    PrintWriter writer = response.getWriter();
                    writer.write(ex.toString());
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        } else {
            return null;
        }
    }
}
