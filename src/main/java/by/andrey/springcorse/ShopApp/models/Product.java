package by.andrey.springcorse.ShopApp.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
public class Product {          //сюда нужно собрать статическое описание сущности (товара)

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "index")     //внутренние индексы магазина (маркировка) м.б. и буквы и цифры
    @NotEmpty
    private String index;

    @NotEmpty
    @Size(min = 3, max = 50, message = "The name must be in the range of 3 to 50 characters")
    @Column(name = "name")
    private String name;

    @Column(name = "type")      // типы продумать нужно ENUM сделать по видам
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
}
