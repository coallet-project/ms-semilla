package com.coallet.semilla.adapter.message;

import com.coallet.semilla.application.port.out.MessageProviderRepository;
import com.coallet.semilla.domain.message.BaseMessage;
import java.util.Locale;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class MessageProvidesAdapter implements MessageProviderRepository {

    private final MessageSource messageSource;

    @Override
    public String get(BaseMessage message, Object... params) {
        return messageSource.getMessage(message.getProperty(), params, getCurrentLocale());
    }

    private Locale getCurrentLocale() {
        return LocaleContextHolder.getLocale();
    }

}
