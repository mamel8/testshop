package by.andrey.springcorse.ShopApp.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "type_product")
public class TypeProduct {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

  /*  @OneToMany(mappedBy = "type")           // разбираться с запросом. ео убираю все работает
    private List<Product> product;*/


    public TypeProduct() {
    }

    public TypeProduct(int id, String name) {
        this.id = id;
        this.name = name;
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

  /*  public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }*/

    @Override
    public String toString() {
        return "TypeProduct{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }
}
