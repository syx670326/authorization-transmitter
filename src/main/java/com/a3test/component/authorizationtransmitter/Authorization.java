package com.a3test.component.authorizationtransmitter;

/**
 * @author eason
 *
 */
public class Authorization {
    public static final String AUTHORIZATION_SCOPE = "AUTHORIZATION-SCOPE";

    private String accessToken;
    private AuthorizationScope scope;

    public Authorization() {
        super();
    }

    public Authorization(String accessToken, AuthorizationScope scope) {
        super();
        this.accessToken = accessToken;
        this.scope = scope;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public AuthorizationScope getScope() {
        return scope;
    }

    public void setScope(AuthorizationScope scope) {
        this.scope = scope;
    }
}
