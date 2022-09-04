package by.andrey.springcorse.ShopApp.repositories;

import by.andrey.springcorse.ShopApp.models.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProductRepository extends JpaRepository<TypeProduct, Integer> {
}
