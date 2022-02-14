package hiber.model;

import javax.persistence.*;
import java.util.Objects;

import static java.util.Objects.hash;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="car")
   private Car car;


   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   public User() {}

   public User(String firstName, String lastName, String email) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }
   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car= car;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == this) {
         return true;
      }
      if (obj == null || obj.getClass() != this.getClass()) {
         return false;
      }

      User user = (User) obj;
      return
              (Objects.equals(firstName, user.firstName)
                      || (firstName != null && firstName.equals(user.getFirstName()))) && (Objects.equals(lastName, user.lastName)
                      || (lastName != null && lastName.equals(user.getLastName())
              ));
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
      result = (int) (prime * result + (hash(firstName)+hash(lastName)));
      result = prime * result + ((lastName == null) ? 0 : (lastName.hashCode() >>> 31));
      return result;
   }

   @Override
   public String toString() {
      return String.format("User: Id = %d,\nName = %s,\nLastname = %s,\nEmail = %s,\n%s", id, firstName, lastName, email, (car != null ? car.toString() : "No car"));
   }
}
