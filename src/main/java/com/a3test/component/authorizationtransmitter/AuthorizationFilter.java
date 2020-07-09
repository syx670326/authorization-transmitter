package com.a3test.component.authorizationtransmitter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.net.HttpHeaders;

/**
 * @author eason
 *
 */
public class AuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        try {
            Authorization auth = new Authorization();
            HttpServletRequest servletRequest = (HttpServletRequest) request;

            String scopeJson = servletRequest.getHeader(Authorization.AUTHORIZATION_SCOPE);
            if (StringUtils.isNotEmpty(scopeJson)) {
                AuthorizationScope scope = JSON.parseObject(scopeJson, AuthorizationScope.class);
                auth.setScope(scope);
            }
            String accessToken = servletRequest.getHeader(HttpHeaders.AUTHORIZATION);
            if (StringUtils.isNotEmpty(accessToken)) {
                auth.setAccessToken(accessToken);
            }
            AuthorizationHolder.set(auth);

            chain.doFilter(request, response);
        } finally {
            AuthorizationHolder.shutdown();
        }
    }
}
