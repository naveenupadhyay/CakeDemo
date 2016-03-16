
package com.walmart.cakedemo.db.users;

import java.util.List;

import com.walmart.cakedemo.entity.User;
import com.walmart.cakedemo.entity.UserRole;

public interface IUsersDao {

    public User getUserById(int userId);

    public User getUserByEmail(String email);

    public void persistUser(User user);

    public User updateUser(User user);

    public boolean isUserExists(String email);

    public UserRole persistUserRole(UserRole userRole);

    public List<UserRole> getEnabledUserRoleMapping(User user, String fcCode);

    void deleteUserRole(UserRole userRole);

    UserRole updateUserRole(UserRole userRole);

    List<UserRole> getAllUserRoles(User u);

    User getUserByEmailForEdit(String email);
}
