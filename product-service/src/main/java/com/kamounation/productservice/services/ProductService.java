package com.kamounation.productservice.services;

import com.kamounation.productservice.dto.ProductResponse;
import com.kamounation.productservice.models.Product;
import com.kamounation.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    private  final ProductRepository productRepository;

    // Use this product constructor for initializing the mongo repo in place of @RequiredArgsConstructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(com.kamounation.productservice.dto.ProductRequest productRequest){
        Product product = Product.builder().name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        this.productRepository.save(product);
       // log.info("Product" + product.getId() +"has been saved");
        // this approach below is only possible because of @Slf4j
        log.info("Product {} has been saved", product.getId());
    }

    protected ProductResponse mapToProductResponse(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public List<ProductResponse> getProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }
}
