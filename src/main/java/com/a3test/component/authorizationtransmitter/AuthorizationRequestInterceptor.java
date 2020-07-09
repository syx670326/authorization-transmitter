package com.a3test.component.authorizationtransmitter;

import com.alibaba.fastjson.JSON;
import com.google.common.net.HttpHeaders;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author eason
 *
 */
public class AuthorizationRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {
        Authorization authorization = AuthorizationHolder.get();
        if (authorization != null) {
            if (authorization.getAccessToken() != null) {
                template.header(HttpHeaders.AUTHORIZATION, authorization.getAccessToken());
            }
            if (authorization.getScope() != null) {
                String scopeJson = JSON.toJSONString(authorization.getScope());
                template.header(Authorization.AUTHORIZATION_SCOPE, scopeJson);
            }
        }
    }
}
