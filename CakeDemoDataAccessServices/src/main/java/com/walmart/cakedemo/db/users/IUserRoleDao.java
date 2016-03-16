
package com.walmart.cakedemo.db.users;

import java.util.List;

import com.walmart.cakedemo.entity.Role;
import com.walmart.cakedemo.entity.User;
import com.walmart.cakedemo.entity.UserRole;

public interface IUserRoleDao {

    Role getRoleByCode(String code);
	
    List<Role> getImmediateChildRoles(Role role);

    List<UserRole> getUserRoleMappingForUser(User user);
}
