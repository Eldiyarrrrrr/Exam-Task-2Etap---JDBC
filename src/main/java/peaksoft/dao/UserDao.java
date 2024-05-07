package peaksoft.dao;

import peaksoft.entity.User;

public interface UserDao {
    void  createUser();
    void addUser(User user);
    void updateUser(Long userId, User user);
    User getUserById(Long userId);
    String deleteUserById(Long userId);
    String changeRoleByUserNameAndPassword(String userName, String password, String newRole);
    String getUserRole(String role);
}
