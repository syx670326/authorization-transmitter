package com.a3test.component.authorizationtransmitter;

import java.util.List;

/**
 * @author eason
 *
 */
public class AuthorizationScope {
    private String userId;
    private List<String> roleIds;

    public AuthorizationScope() {
        super();
    }

    public AuthorizationScope(String userId, List<String> roleIds) {
        super();
        this.userId = userId;
        this.roleIds = roleIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }
}
