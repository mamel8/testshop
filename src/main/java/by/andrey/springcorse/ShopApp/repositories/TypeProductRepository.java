package by.andrey.springcorse.ShopApp.repositories;

import by.andrey.springcorse.ShopApp.models.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeProductRepository extends JpaRepository<TypeProduct, Integer> {

 //   @Query("SELECT u FROM type_product u where u.name is not null ")
 //   @Query(value = "SELECT u FROM type_product u ORDER BY id", nativeQuery = true)
  //  List<TypeProduct> findAllByTypeProduct();
}
