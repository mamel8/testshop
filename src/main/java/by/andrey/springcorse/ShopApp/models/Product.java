package by.andrey.springcorse.ShopApp.models;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {         /** сюда нужно собрать статическое описание сущности (товара)
                                 ЕСЛИ НУЖНЫ ДОПОЛНИТЕЛЬНЫЕ ХАРАКТЕРИСТИКИ ТОВАРА
                                МОЖНО ДОБАВИТЬ ДОП. ТАБЛИЦУ ПРОКИНУТЬ СВЯЗЬ 1/1
                            И ПРОПИСЫВАТЬ ЧТО НУЖНО ПО ПОЛЯМ, ЧТО НЕТ СЕТИМ null */

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "index")     //внутренние индексы магазина (маркировка) м.б. и буквы и цифры
    @NotEmpty                   //а может и не нужен обойтись ID только
    private String index;

    @ManyToOne
    @JoinColumn(name = "type_product", referencedColumnName = "id")
    private TypeProduct type;

    @NotEmpty
    @Size(min = 3, max = 50, message = "The name must be in the range of 3 to 50 characters")
    @Column(name = "name")
    private String name;

    @Column(name = "unit")      //Единица измерения
    @NotEmpty
    private String unit;

    @Column(name = "price")
    private Double price;

    @Column(name = "country")      //страна производитель
    @NotEmpty
    private String country;

    @Column(name = "maker")      //фирма производитель
    @NotEmpty
    private String maker;

    @Column(name = "creation_date")             //дата создания сущности(первое появление в бд)
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "product")
    private List<Basket> prod;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public TypeProduct getType() {
        return type;
    }

    public void setType(TypeProduct type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Product(int id, String index, TypeProduct type, String name, String unit, Double price,
                   String country, String maker, LocalDateTime creationDate) {
        this.id = id;
        this.index = index;
        this.type = type;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.country = country;
        this.maker = maker;
        this.creationDate = creationDate;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", index='" + index + '\'' +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", country='" + country + '\'' +
                ", maker='" + maker + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }


}
