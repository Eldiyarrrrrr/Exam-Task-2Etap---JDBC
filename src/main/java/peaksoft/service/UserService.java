package peaksoft.service;

import peaksoft.entity.User;

public interface UserService {
    void createUser();
    void addUser(User user);
    User getUserById(Long userId);
    void updateUser(Long userId, User user);
    String deleteUserById(Long userId);
    String changeRoleByUserNameAndPassword(String userName, String password, String newRole);
    String getUserRole(String role);
}
