package by.andrey.springcorse.ShopApp.controllers;

import by.andrey.springcorse.ShopApp.dto.ProductDTO;
import by.andrey.springcorse.ShopApp.dto.ProductDtoService;
import by.andrey.springcorse.ShopApp.models.Product;
import by.andrey.springcorse.ShopApp.services.ProductService;
import by.andrey.springcorse.ShopApp.services.RegistrationService;
import by.andrey.springcorse.ShopApp.util.NotCreatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class PersonController {

    private final ProductService productService;

    private final ProductDtoService productDtoService;

    private final RegistrationService registrationService;

    public PersonController(ProductService productService, ProductDtoService productDtoService, RegistrationService registrationService) {
        this.productService = productService;
        this.productDtoService = productDtoService;
        this.registrationService = registrationService;
    }


    @GetMapping
    public List<ProductDTO> adminCheck(){
        List<ProductDTO> list2 = new ArrayList<>();
        productService.findAll()
                .stream()
                .map(s->list2.add(productDtoService.convertToProductDTO(s)))
                .collect(Collectors.toList());
        return list2;
    }
//
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addProduct(@RequestBody @Valid ProductDTO productDTO, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error: errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append("; ");
            }
            throw new NotCreatedException(errorMsg.toString());
        }
        registrationService.addProduct(productDtoService.convertToProduct(productDTO));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}