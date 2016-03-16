
package com.walmart.cakedemo.web.security;

import org.springframework.security.core.GrantedAuthority;

import com.walmart.cakedemo.entity.Role;

public class CakeDemoAuthority implements GrantedAuthority {

    private static final long serialVersionUID = 68620155670337310L;
    private final String      role;

    public CakeDemoAuthority(Role role) {
        this.role = role.getCode();
    }

    @Override
    public String getAuthority() {
        return role;
    }

}
