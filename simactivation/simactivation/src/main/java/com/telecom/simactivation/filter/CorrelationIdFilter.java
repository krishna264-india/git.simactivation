package com.telecom.simactivation.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class CorrelationIdFilter implements Filter{
    private static final String CORRELATION_ID = "correlationId";

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        if (!(request instanceof HttpServletRequest httpRequest)) {
            chain.doFilter(request, response);
            return;
        }
//To trace a request across multiple microservices and logs.
        String correlationId = httpRequest.getHeader(CORRELATION_ID);

        if (correlationId == null) {
            correlationId = UUID.randomUUID().toString();
        }
//MDC (Mapped Diagnostic Context) is used to store request-specific data
// (like correlationId) for logging across threads.
        MDC.put(CORRELATION_ID, correlationId);
        ((jakarta.servlet.http.HttpServletResponse) response)
                .setHeader(CORRELATION_ID, correlationId);

        try {
            chain.doFilter(request, response);
        } finally {
            MDC.remove(CORRELATION_ID);
        }
    }
}
