package com.myorg.propertymanagement.utils;

import com.myorg.propertymanagement.response.ResponseWrapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class LogInterceptor implements HandlerInterceptor {

    private final Logger logger = LoggerFactory.getLogger(LogInterceptor.class);

    private static final ThreadLocal<Long> startTimeThreadLocal = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        String requestURI = request.getRequestURI();
        Map<String, String> parameters = getRequestParameters(request);

        if (!(response instanceof ResponseWrapper)) {
            ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) response);
            request.setAttribute("responseWrapper", responseWrapper);
        }

        logger.info("Incoming request: Method={}, URI={}, Parameters={}", method, requestURI, parameters);

        startTimeThreadLocal.set(System.currentTimeMillis());

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = startTimeThreadLocal.get();
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        if (ex != null) {
            logger.error("Request completed with error: {}", ex.getMessage(), ex);
        } else {
            ResponseWrapper responseWrapper = (ResponseWrapper) request.getAttribute("responseWrapper");
            String responseBody = "";
            if (responseWrapper != null) {
                responseBody = responseWrapper.getCapturedResponseBody();
                responseWrapper.copyBodyToResponse();  // Ensure the body is written back to the response
            }
            logger.info("Request completed successfully: Response = {}, Status={}, TimeTaken={}ms", responseBody, response.getStatus(), duration);
        }

        startTimeThreadLocal.remove();
    }

    private Map<String, String> getRequestParameters(HttpServletRequest request) {
        Map<String, String> params = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            params.put(paramName, request.getParameter(paramName));
        }

        return params;
    }
}
