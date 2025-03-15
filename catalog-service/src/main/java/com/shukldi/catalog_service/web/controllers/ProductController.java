package com.shukldi.catalog_service.web.controllers;


import com.shukldi.catalog_service.domain.PageResult;
import com.shukldi.catalog_service.domain.Product;
import com.shukldi.catalog_service.domain.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PageResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getProducts(pageNo);
    }

    @GetMapping("/{code}")
    Optional<Product> getProduct(@PathVariable String code) {
        return productService.getProduct(code);
    }
}
