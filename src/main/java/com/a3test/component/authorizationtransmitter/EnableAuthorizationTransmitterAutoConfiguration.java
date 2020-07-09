package com.a3test.component.authorizationtransmitter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eason
 *
 */
@Configuration
public class EnableAuthorizationTransmitterAutoConfiguration {
    @Bean
    public AuthorizationRequestInterceptor authorizationRequestInterceptor() {
        return new AuthorizationRequestInterceptor();
    }

    @Bean
    public AuthorizationFilter authorizationFilter() {
        return new AuthorizationFilter();
    }
}
