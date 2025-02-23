package com.shukldi.catalog_service.domain;

public class ProductMapper {
    static Product toProduct(ProductEntity entity) {
        return new Product(entity.getId(), entity.getCode(), entity.getName(), entity.getDescription(), entity.getImageUrl(), entity.getPrice());
    }

    static ProductEntity toProductEntity(Product product) {
        return new ProductEntity(product.id(), product.code(), product.name(), product.description(), product.price(), product.imageUrl());
    }
}
