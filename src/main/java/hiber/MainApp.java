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

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user1 = new User("Maxim", "Lavrov", "emailMaxLavr@mail.com");
      User user2 = new User("Viktor", "Barinov", "emailVikBar@mail.com");
      User user3 = new User("Dmitry", "Nagiev", "emailDmiNag@mail.com");
      User user4 = new User("Viktoriya", "Goncharova", "emaiVikGonN@mail.com");
      Car car1 = new Car("2109",11);
      Car car2 = new Car("Porshe",22);
      Car car3 = new Car("Toyota",33);
      Car car4 = new Car("Nissan",44);
      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);
      user4.setCar(car4);
      userService.addCar(user1, car1);
      userService.addCar(user2, car2);
      userService.addCar(user3, car3);
      userService.addCar(user4, car4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
         System.out.println();
      }

      System.out.println("Машиной(Nissan, 44) владеет:");

      List<User> usersByCar = userService.findUser("Nissan", 44);
      for (User user : usersByCar) {
         System.out.println(user);
         System.out.println();
      }
      context.close();
   }
}
