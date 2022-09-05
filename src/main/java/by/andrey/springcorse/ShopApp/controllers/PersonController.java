package by.andrey.springcorse.ShopApp.controllers;

import by.andrey.springcorse.ShopApp.dto.ProductDTO;
import by.andrey.springcorse.ShopApp.dto.ProductDtoService;
import by.andrey.springcorse.ShopApp.models.Product;
import by.andrey.springcorse.ShopApp.models.TypeProduct;
import by.andrey.springcorse.ShopApp.services.ProductService;
import by.andrey.springcorse.ShopApp.services.RegistrationService;
import by.andrey.springcorse.ShopApp.util.ExceptionReg;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping
public class PersonController {

    private final ProductService productService;

    private final ProductDtoService productDtoService;

    private final RegistrationService registrationService;

    private final ExceptionReg exceptionReg;

    public PersonController(ProductService productService, ProductDtoService productDtoService,
                            RegistrationService registrationService, ExceptionReg exceptionReg) {
        this.productService = productService;
        this.productDtoService = productDtoService;
        this.registrationService = registrationService;
        this.exceptionReg = exceptionReg;
    }

    @GetMapping
    public List<TypeProduct> checkTypeProd(){
        return productService.findAllType();
    }

    @GetMapping("/{id}")
    public List<Product> checkProductByTypeProduct(@PathVariable Integer id){
        return productService.findProdByType(id);
    }



    @GetMapping("/products")
    public List<Product> checkAllProd(){
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product checkProductById(@PathVariable Integer id){
        return productService.findProductById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addProduct(@RequestBody @Valid ProductDTO productDTO, BindingResult bindingResult){
        exceptionReg.except(bindingResult);
        registrationService.addProduct(productDtoService.convertToProduct(productDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}