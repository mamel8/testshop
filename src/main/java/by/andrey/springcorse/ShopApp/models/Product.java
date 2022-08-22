package by.andrey.springcorse.ShopApp.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {          //сюда нужно собрать статическое описан ие сущности (товара)

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "index")     //внутренние индексы магазина (маркировка) м.б. и буквы и цифры
    @NotEmpty                   //а может и не нужен обойтись ID только
    private String index;

    @NotEmpty
    @Size(min = 3, max = 50, message = "The name must be in the range of 3 to 50 characters")
    @Column(name = "name")
    private String name;

    @Column(name = "type")      // типы продумать нужно ENUM сделать по видам или отдельную Таблицк на №группы товаров 2-3столбца
    private String type;

    @Column(name = "unit")      //Единица измерения
    @NotEmpty
    private String unit;

    @Column(name = "quantity")      //количество может нужно и вынести из этой сущности в ТТН или приход
    @NotEmpty                       // ЭТО НЕ СТАТИЧЕСКАЯ ПЕРЕМЕННАЯ для этой сущности
    private Double quantity;

    @Column(name = "price")
    @NotEmpty
    private double price;

    @Column(name = "creation_date")             //дата создания сущности(первое появление в бд)
    @NotEmpty
    private LocalDateTime creationDate;

    @Column(name = "country")      //страна производитель
    @NotEmpty
    private String country;

    @Column(name = "maker")      //фирма производитель
    @NotEmpty
    private String maker;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}
