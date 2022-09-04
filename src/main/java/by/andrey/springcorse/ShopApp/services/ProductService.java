package by.andrey.springcorse.ShopApp.services;

import by.andrey.springcorse.ShopApp.models.Product;
import by.andrey.springcorse.ShopApp.models.TypeProduct;
import by.andrey.springcorse.ShopApp.repositories.ProductRepository;
import by.andrey.springcorse.ShopApp.repositories.TypeProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final TypeProductRepository typeProductRepository;

    public ProductService(ProductRepository productRepository, TypeProductRepository typeProductRepository) {
        this.productRepository = productRepository;
        this.typeProductRepository = typeProductRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<TypeProduct> findAllType() {
        return typeProductRepository.findAll();
    }
}
