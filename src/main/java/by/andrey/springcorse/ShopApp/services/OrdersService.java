package by.andrey.springcorse.ShopApp.services;

import by.andrey.springcorse.ShopApp.models.Orders;
import by.andrey.springcorse.ShopApp.repositories.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;


    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> findAllOrders() {
        return ordersRepository.findAll();
    }
}
