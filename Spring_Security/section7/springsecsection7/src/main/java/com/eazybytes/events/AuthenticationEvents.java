package com.eazybytes.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AuthenticationEvents {
    public void onSuccess(AuthenticationSuccessEvent successEvent) {
        log.info("Successfully authenticated for the user: {}", successEvent.getAuthentication().getName());
    }

    public void onFailure(AbstractAuthenticationFailureEvent failureEvent) {
        log.error("Login failed for the user: {} due to: {}", failureEvent.getAuthentication().getName(),
                failureEvent.getException().getMessage());
    }
}
