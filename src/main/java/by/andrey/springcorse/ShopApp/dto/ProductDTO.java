package by.andrey.springcorse.ShopApp.dto;

import javax.persistence.Column;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProductDTO {

    @NotEmpty                   //а может и не нужен обойтись ID только
    private String index;

    @NotEmpty
    @Size(min = 3, max = 50, message = "The name must be in the range of 3 to 50 characters")
    private String name;

    @Column(name = "type")      // типы продумать нужно ENUM сделать по видам или отдельную Таблицк на №группы товаров 2-3столбца
    private String type;

    @NotEmpty
    private String unit;         //Единица измерения


    private Double price;

    @NotEmpty
    private String country;

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
}
