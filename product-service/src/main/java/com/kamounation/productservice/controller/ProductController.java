package com.kamounation.productservice.controller;

import com.kamounation.productservice.dto.ProductRequest;
import com.kamounation.productservice.dto.ProductResponse;
import com.kamounation.productservice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    // Because of @RequiredArsController, we don't need to inject the Product service manually
    private  final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest prodRequest){
        productService.createProduct(prodRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getProducts(){
         return productService.getProducts();
    }
}
