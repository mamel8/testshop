package by.andrey.springcorse.ShopApp.dto;

import by.andrey.springcorse.ShopApp.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDtoService {

    private final ModelMapper modelMapper;

    @Autowired
    public ProductDtoService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Product convertToProduct(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

    public ProductDTO convertToProductDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }
}
