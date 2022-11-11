package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      Car car1 = new Car("Car1", 1);
      Car car2 = new Car("Car2", 2);
      Car car3 = new Car("Car3", 3);
      Car car4 = new Car("Car4", 4);

      User user1 = new User(car1, "User1", "Lastname1", "user1@mail.ru");
      User user2 = new User(car2, "User2", "Lastname2", "user2@mail.ru");
      User user3 = new User(car3, "User3", "Lastname3", "user3@mail.ru");
      User user4 = new User(car4, "User4", "Lastname4", "user4@mail.ru");

      userService.add((user1));
      userService.add((user2));
      userService.add((user3));
      userService.add((user4));
      
      //List<User> users = userService.listUsers();

      for (User user : userService.listUsers()) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
      }

      System.out.println(userService.getUserByCar("Car1", 1));

      context.close();
   }
}
