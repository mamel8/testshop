package by.andrey.springcorse.ShopApp.models;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "person2")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, max = 30, message = "The name must be in the range of 3 to 30 characters")
    @NotEmpty(message = "Not Null")
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "phone", length = 20)
    @NotEmpty(message = "Not Null")
    private String phone;

    @Column(name = "email", unique = true, length = 35)
    @Email
    @NotEmpty(message = "Not Null")
    @Size(min = 5, message = "Enter your email")
    private String email;

    @Column(name = "password", length = 100)
    @Size(min = 3, max = 100, message = "Your pass must be in the range of 3 to 100 characters")
    @NotEmpty(message = "Not Null")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "city")
    private String city;

    @Column(name = "area")
    private String area;

    @Column(name = "postal_code")
    private int postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "role", length = 10)
    @Enumerated(EnumType.STRING)
    private PersonRole role;

    @Column(name = "update_date")
    @Timestamp
    private LocalDateTime updateDate;

    @Column(name = "registration")
    @Timestamp
    private LocalDateTime registration;

    @Column(name = "is_Enabled")
    private boolean isEnabled = true;

/*    @OneToMany(mappedBy = "costumer_id")
    private List<Orders> costumerOrder;

    @OneToMany(mappedBy = "manager_id")
    private List<Orders> costumerManager;*/

    public Person(int id, String name, String phone, String email, String password, int age, String city,
                  String area, int postalCode, String country, PersonRole role, LocalDateTime updateDate,
                  LocalDateTime registration, boolean isEnabled, List<Orders> costumerOrder, List<Orders> costumerManager) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.age = age;
        this.city = city;
        this.area = area;
        this.postalCode = postalCode;
        this.country = country;
        this.role = role;
        this.updateDate = updateDate;
        this.registration = registration;
        this.isEnabled = isEnabled;
/*        this.costumerOrder = costumerOrder;
        this.costumerManager = costumerManager;*/
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", postalCode=" + postalCode +
                ", country='" + country + '\'' +
                ", role=" + role +
                ", updateDate=" + updateDate +
                ", registration=" + registration +
                ", isEnabled=" + isEnabled +
/*                ", costumerOrder=" + costumerOrder +
                ", costumerManager=" + costumerManager +*/
                '}';
    }

/*    public List<Orders> getCostumerOrder() {
        return costumerOrder;
    }

    public void setCostumerOrder(List<Orders> costumerOrder) {
        this.costumerOrder = costumerOrder;
    }

    public List<Orders> getCostumerManager() {
        return costumerManager;
    }

    public void setCostumerManager(List<Orders> costumerManager) {
        this.costumerManager = costumerManager;
    }*/

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public PersonRole getRole() {
        return role;
    }

    public void setRole(PersonRole role) {
        this.role = role;
    }

    public LocalDateTime getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDateTime registration) {
        this.registration = registration;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}


