package com.kh0ma.product_requester_api.mappers;

import com.kh0ma.product_requester_api.dto.ProductDto;
import com.kh0ma.product_requester_domain.domain.entity.Product;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Olexander Khomenko
 */

public final class ProductMapper {

    private ProductMapper() {
    }

    public static ProductDto domainToDto(final Product product) {
        ProductDto result = new ProductDto();

        result.setName(product.getName());
        result.setDescription(product.getDescription());
        result.setPrice(product.getPrice());
        result.setProductCategoryId(product.getProductCategoryId());

        return result;
    }

    public static Product dtoToDomain(final ProductDto productDto) {
        Product result = new Product();

        result.setName(productDto.getName());
        result.setDescription(productDto.getDescription());
        result.setPrice(productDto.getPrice());
        result.setProductCategoryId(productDto.getProductCategoryId());

        return result;
    }


    public static List<ProductDto> domainsToDto(final List<Product> list) {
        return list
                .stream()
                .map(ProductMapper::domainToDto)
                .collect(Collectors.toList());
    }
}
