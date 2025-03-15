package com.shukldi.catalog_service.domain;

import com.shukldi.catalog_service.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final ApplicationProperties applicationProperties;

    public ProductService(ProductRepository productRepository, ApplicationProperties applicationProperties) {
        this.productRepository = productRepository;
        this.applicationProperties = applicationProperties;
    }

    public PageResult<Product> getProducts(int pageNo) {
        Sort sort = Sort.by("name").ascending();
        pageNo = pageNo < 1 ? 0 : pageNo - 1;
        Pageable pageable = PageRequest.of(pageNo, applicationProperties.pageSize(), sort);
        Page<Product> products = productRepository.findAll(pageable)
                .map(ProductMapper:: toProduct);

        PageResult<Product> pageResult = new PageResult<>(
                products.getContent(),
                products.getTotalElements(),
                products.getNumber() + 1,
                products.getTotalPages(),
                products.hasNext(),
                products.hasPrevious(),
                products.isFirst(),
                products.isLast());

        return pageResult;
    }

    public Optional<Product> getProduct(String code) {
        return Optional.ofNullable(productRepository.findByCode(code)
                .map(ProductMapper::toProduct)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with code: " + code)));
    }
}