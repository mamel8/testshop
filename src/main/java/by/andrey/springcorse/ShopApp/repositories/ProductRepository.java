package by.andrey.springcorse.ShopApp.repositories;


import by.andrey.springcorse.ShopApp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "Select * from product where type_product=?1", nativeQuery = true)
    List<Product> findProducts(Integer id);
}
