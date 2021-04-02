package com.coallet.semilla.adapter.controller.advice;

import com.coallet.semilla.adapter.controller.model.RestResponseError;
import com.coallet.semilla.application.port.out.MessageProviderRepository;
import com.coallet.semilla.domain.message.General;
import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
@AllArgsConstructor
public class HandlerController {

    private final HttpServletRequest httpServletRequest;
    private final MessageProviderRepository messageProvider;

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<RestResponseError> handle(Throwable ex) {
        log.error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex);

        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR,
            messageProvider.get(General.INTERNAL_SERVER_ERROR));
    }

    private ResponseEntity<RestResponseError> buildResponse(HttpStatus httpStatus, String message) {

        var response = RestResponseError.builder()
            .status(httpStatus.value())
            .timestamp(LocalDateTime.now())
            .resource(httpServletRequest.getRequestURI())
            .detail(message)
            .build();

        return new ResponseEntity<>(response, httpStatus);
    }

}
