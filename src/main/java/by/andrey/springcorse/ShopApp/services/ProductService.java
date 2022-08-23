package by.andrey.springcorse.ShopApp.services;

import by.andrey.springcorse.ShopApp.models.Product;
import by.andrey.springcorse.ShopApp.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
