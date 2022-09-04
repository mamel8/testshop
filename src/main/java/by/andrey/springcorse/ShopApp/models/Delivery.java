package by.andrey.springcorse.ShopApp.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "Delivery")
public class Delivery {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "phone", length = 20)
    @NotEmpty(message = "Not Null")
    private String phone;

    @Column(name = "city")
    private String city;

    @Column(name = "area")
    private String area;

    @Column(name = "postal_code")
    private int postal_code;

    @Column(name = "country")
    private String country;

/*    @OneToMany(mappedBy = "delivery_id")
    private List<Orders> deliver;*/

    public Delivery(int id, String phone, String city, String area, int postal_code, String country) {
        this.id = id;
        this.phone = phone;
        this.city = city;
        this.area = area;
        this.postal_code = postal_code;
        this.country = country;
    }

    public Delivery() {
    }

/*    public List<Orders> getDeliver() {
        return deliver;
    }

    public void setDeliver(List<Orders> deliver) {
        this.deliver = deliver;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", postal_code=" + postal_code +
                ", country='" + country + '\'' +
                '}';
    }
}
