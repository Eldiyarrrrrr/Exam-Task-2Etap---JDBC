package peaksoft;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DataBaseConfig;
import peaksoft.entity.User;
import peaksoft.service.serviceImpl.UserServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        UserServiceImpl userService = new UserServiceImpl();
//        userService.createUser();
//        userService.addUser(new User("Eldiyar","1234567","Mentor"));
//        System.out.println(userService.getUserById(1L));
//          userService.updateUser(1L,new User("Beka","5678","Instruktor"));
//        System.out.println(userService.changeRoleByUserNameAndPassword("Beka", "5678", "Instruktor"));
//        System.out.println(userService.getUserRole("Instruktor"));
        System.out.println(userService.deleteUserById(2L));
    }
}
