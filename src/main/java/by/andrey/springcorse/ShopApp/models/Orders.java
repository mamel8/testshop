package by.andrey.springcorse.ShopApp.models;

import jdk.jfr.Timestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "costumer_id", referencedColumnName = "id")
    private Person costumer_id;

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    private Person manager_id;

    @ManyToOne
    @JoinColumn(name = "delivery_id", referencedColumnName = "id")
    private Delivery delivery_id;

    @Column(name = "registration_order")
    @Timestamp
    private LocalDateTime registration_order;

    @Column(name = "cost_order")
    private float cost_order;

/*    @OneToMany(mappedBy = "order")
    private List<Basket> basket;*/

    public Orders(int id, Person costumer_id, Person manager_id, Delivery delivery_id,
                  LocalDateTime registration_order, float cost_order, List<Basket> basket) {
        this.id = id;
        this.costumer_id = costumer_id;
        this.manager_id = manager_id;
        this.delivery_id = delivery_id;
        this.registration_order = registration_order;
        this.cost_order = cost_order;
  //      this.basket = basket;
    }

    public Orders() {
    }

/*    public List<Basket> getBasket() {
        return basket;
    }

    public void setBasket(List<Basket> basket) {
        this.basket = basket;
    }*/

    public Person getCostumer_id() {
        return costumer_id;
    }

    public void setCostumer_id(Person costumer_id) {
        this.costumer_id = costumer_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getManager_id() {
        return manager_id;
    }

    public void setManager_id(Person manager_id) {
        this.manager_id = manager_id;
    }

    public Delivery getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(Delivery delivery_id) {
        this.delivery_id = delivery_id;
    }

    public LocalDateTime getRegistration_order() {
        return registration_order;
    }

    public void setRegistration_order(LocalDateTime registration_order) {
        this.registration_order = registration_order;
    }

    public float getCost_order() {
        return cost_order;
    }

    public void setCost_order(float cost_order) {
        this.cost_order = cost_order;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", costumer_id=" + costumer_id +
                ", manager_id=" + manager_id +
                ", delivery_id=" + delivery_id +
                ", registration_order=" + registration_order +
                ", cost_order=" + cost_order +
                '}';
    }
}
