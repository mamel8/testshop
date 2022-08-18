package by.andrey.springcorse.ShopApp.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

 //   @NotEmpty
  //  @Size(min = 3, max = 20, message = "The name must be in the range of 3 to 20 characters")
    @Column(name = "name")
    private String name;

    @Column(name = "email")
 //   @Email
  //  @Size(min = 5, message = "Enter your email")
    private String email;

    @Column(name = "registration")
    private LocalDateTime registration;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
  //  @Size(min = 3)
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private PersonRole role;

    public PersonRole getRole() {
        return role;
    }

    public void setRole(PersonRole role) {
        this.role = role;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person(String name, String email, String phone, PersonRole role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDateTime registration) {
        this.registration = registration;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email=" + email +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}


