package com.shukldi.catalog_service.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    @SequenceGenerator(name = "product_id_generator", sequenceName = "product_id_seq")
    private Long id;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "Product code is required")
    private String code;

    @Column(nullable = false)
    @NotEmpty(message = "Product name is required")
    private String name;

    private String description;

    @Column(nullable = false)
    @NotNull(message = "Product price is required")
    @DecimalMin("0.1")
    private BigDecimal price;

    private String imageUrl;

    public ProductEntity(Long id, String code, String name, String description, BigDecimal price, String s) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = s;
    }

    public Long getId() {
        return id;
    }

    public @NotEmpty(message = "Product code is required") String getCode() {
        return code;
    }

    public @NotEmpty(message = "Product name is required") String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public @NotNull(message = "Product price is required") @DecimalMin("0.1") BigDecimal getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(@NotEmpty(message = "Product code is required") String code) {
        this.code = code;
    }

    public void setName(@NotEmpty(message = "Product name is required") String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(@NotNull(message = "Product price is required") @DecimalMin("0.1") BigDecimal price) {
        this.price = price;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}