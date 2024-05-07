package peaksoft.dao.daoImpl;


import peaksoft.config.DataBaseConfig;
import peaksoft.dao.UserDao;
import peaksoft.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDaoImpl implements UserDao {
    private final Connection connectionn = DataBaseConfig.getConnection();


    @Override
    public void createUser() {
        String sql = "create table if not exists users(\n" +
                "                                    id serial primary key,\n" +
                "                                    user_name varchar(50),\n" +
                "                                    password varchar(50),\n" +
                "                                    user_role varchar(50) \n" +
                "                                    )";
        try (Statement statement = connectionn.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Table 'users' successfully created");
        } catch (Exception e) {
            System.out.println("Error creating table 'users': " + e.getMessage());
        }
    }

    @Override
    public void addUser(User user) {
        String sql = """
                insert into users(user_name, password, user_role)
                values(?,?,?); """;
        try (PreparedStatement preparedStatement = connectionn.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.executeUpdate();
            System.out.println("Sussessfully added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void updateUser(Long id, User user) {
        String sql = """
                update users set user_name = ?,
                 password = ?,
                 user_role = ?
                where id = ?
                """;
        try (PreparedStatement preparedStatement = connectionn.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getUserName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
            int empId = preparedStatement.executeUpdate();
            if (empId > 0) {
                System.out.println("successfully updated");
            } else {
                throw new RuntimeException("user by id " + id + " not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public User getUserById(Long id) {
        User user = new User();
        try (PreparedStatement preparedStatement = connectionn.prepareStatement("" +
                "select * from users where id =?")) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) throw new RuntimeException("user by email " + id + " not found");
            user.setId(resultSet.getLong("id"));
            user.setUserName(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("user_role"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public String deleteUserById(Long id) {
        String sql = "delete  from users where id =?";
        try (PreparedStatement preparedStatement = connectionn.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            int executeUpdate = preparedStatement.executeUpdate();
            if (executeUpdate > 0) {
                return ("user successfully deleted!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return "user by id " + id + " not found";
    }

    @Override
    public String changeRoleByUserNameAndPassword(String userName, String password, String newRole) {
        User user = new User();
        user.setRole(newRole);
        String sql = "update users set user_role=? where user_name=? and password=?";
        try (PreparedStatement preparedStatement = connectionn.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getRole());
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);
            int executeUpdate = preparedStatement.executeUpdate();
            if (executeUpdate > 0) return "successfully changed";
            throw new RuntimeException("user not found");
        } catch (Exception e) {
            return (e.getMessage());
        }
    }


    @Override
    public String getUserRole(String role) {
        try (PreparedStatement preparedStatement = connectionn.prepareStatement("" +
                "select * from users where user_role =?")) {
            preparedStatement.setString(1, role);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) throw new RuntimeException("user by id " + role + " not found");
            return resultSet.getString("user_role");

        } catch (Exception e) {
            return (e.getMessage());
        }
    }
}
