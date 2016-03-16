
package com.walmart.cakedemo.db.users;

import java.util.List;

import com.webapputils.base.cache.EmailVerificationCode;
import com.walmart.cakedemo.entity.User;
import com.walmart.cakedemo.entity.UserRole;

public interface IUserService {

    public boolean isUserExists(String email);

    public User addUser(User user);

    public User getUserByEmail(String email);

    public User updateUser(User user);

    public UserRole createUserRole(UserRole userRole);

    void persistUser(User user);

    boolean verifyPassword(User user, String password);

    UserRole updateUserRole(UserRole ur);

    List<UserRole> getAllUserRoleMappings(User u);

    public User getUserByEmailForEdit(String email);

}
