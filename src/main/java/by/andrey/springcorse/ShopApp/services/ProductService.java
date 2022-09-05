package by.andrey.springcorse.ShopApp.services;

import by.andrey.springcorse.ShopApp.models.Product;
import by.andrey.springcorse.ShopApp.models.TypeProduct;
import by.andrey.springcorse.ShopApp.repositories.ProductRepository;
import by.andrey.springcorse.ShopApp.repositories.TypeProductRepository;
import by.andrey.springcorse.ShopApp.util.ErrorResponse;
import by.andrey.springcorse.ShopApp.util.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

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



    public List<Product> findProdByType(Integer id) {
        return productRepository.findProducts(id);
    }

    public Product findProductById(Integer id) {
        Optional<Product> foundProduct = productRepository.findById(id);
        return foundProduct.orElseThrow(ProductNotFoundException::new);

    }

    @ExceptionHandler
    private ResponseEntity<ErrorResponse> handleException(ProductNotFoundException e){
        ErrorResponse response = new ErrorResponse("Product with this id was`t found",
                System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
