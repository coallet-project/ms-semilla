package com.coallet.semilla.application.port.out;

import com.coallet.semilla.domain.message.BaseMessage;

public interface MessageProviderRepository {

    String get(BaseMessage message, Object... params);

}
