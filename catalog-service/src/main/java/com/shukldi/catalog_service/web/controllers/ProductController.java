package com.shukldi.catalog_service.web.controllers;


import com.shukldi.catalog_service.domain.PageResult;
import com.shukldi.catalog_service.domain.Product;
import com.shukldi.catalog_service.domain.ProductService;
import com.shukldi.catalog_service.domain.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
class ProductController {

    private final ProductService productService;

    @GetMapping
    PageResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return productService.getProducts(pageNo);
    }

    @GetMapping("/{code}")
    ResponseEntity<Product> getProduct(@PathVariable String code) {
        return productService.getProduct(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }
}
