package com.coallet.semilla.adapter.controller.filter;

import static org.apache.commons.lang3.StringUtils.join;

import java.io.IOException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(200)
public class TransactionLoggingFilter extends OncePerRequestFilter {

    private static final String PATTERN_DATE = "yyMMddhh";
    private static final String KEY_TRANSACTION_LOGGER = "transaction-id";
    private static final String BASE_LONG_VALUE_LENGTH_8 = "00000000";
    private static final int TOP_LONG_VALUE_LENGTH_12 = 999_999_999;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
        FilterChain filterChain) throws ServletException, IOException {

        try {
            MDC.put(KEY_TRANSACTION_LOGGER, generateTransactionId());

            filterChain.doFilter(request, response);
        } finally {
            MDC.remove(KEY_TRANSACTION_LOGGER);
        }
    }

    private String generateTransactionId() {
        var random = new SecureRandom();

        var formatter = new SimpleDateFormat(PATTERN_DATE);

        Long transactionId =
            Long.parseLong(join(formatter.format(new Date()), BASE_LONG_VALUE_LENGTH_8)) +
                random.nextInt(TOP_LONG_VALUE_LENGTH_12);

        return transactionId.toString();
    }

}
