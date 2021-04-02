package com.coallet.semilla.domain.message;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum General implements BaseMessage {

    GENERAL("general-message"),
    INTERNAL_SERVER_ERROR("internal-server-error");

    private final String property;

}
