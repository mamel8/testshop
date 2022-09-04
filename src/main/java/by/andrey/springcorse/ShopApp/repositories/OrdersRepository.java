package by.andrey.springcorse.ShopApp.repositories;

import by.andrey.springcorse.ShopApp.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

}
