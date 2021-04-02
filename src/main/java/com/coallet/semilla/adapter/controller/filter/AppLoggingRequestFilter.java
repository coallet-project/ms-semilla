package com.coallet.semilla.adapter.controller.filter;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.AbstractRequestLoggingFilter;

@Slf4j
@Order(HIGHEST_PRECEDENCE)
@Component
public class AppLoggingRequestFilter extends AbstractRequestLoggingFilter {

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
        log.info("---------- Inicio de request [ {} - {} ]", request.getMethod(),
            request.getRequestURI());
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        log.info("---------- Finalizacion de request [ {} - {} ]", request.getMethod(),
            request.getRequestURI());
    }

}
