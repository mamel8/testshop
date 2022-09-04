package by.andrey.springcorse.ShopApp.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Basket")
public class Basket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cost")
    private float cost;

    @Column(name = "quantity")
    private float quantity;

    @Column(name = "discount")
    private int discount;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders order;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Basket() {
    }

    public Basket(int id, float cost, float quantity, int discount, Orders order, Product product) {
        this.id = id;
        this.cost = cost;
        this.quantity = quantity;
        this.discount = discount;
        this.order = order;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", cost=" + cost +
                ", quantity=" + quantity +
                ", discount=" + discount +
                ", order=" + order +
                ", product=" + product +
                '}';
    }
}



