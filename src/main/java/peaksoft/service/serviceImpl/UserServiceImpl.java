package peaksoft.service.serviceImpl;

import peaksoft.dao.daoImpl.UserDaoImpl;
import peaksoft.entity.User;
import peaksoft.service.UserService;

public class UserServiceImpl implements UserService {
    UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void createUser() {
        userDao.createUser();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public void updateUser(Long userId, User user) {
        userDao.updateUser(userId, user);
    }

    @Override
    public String deleteUserById(Long userId) {
        return userDao.deleteUserById(userId);
    }

    @Override
    public String changeRoleByUserNameAndPassword(String userName, String password, String newRole) {
        return userDao.changeRoleByUserNameAndPassword(userName,password,newRole);
    }

    @Override
    public String getUserRole(String role) {
        return userDao.getUserRole(role);
    }
}
