package com.kh0ma.product_requester_api.mappers;

import com.kh0ma.product_requester_api.dto.ProductCategoryDto;
import com.kh0ma.product_requester_api.dto.ProductDto;
import com.kh0ma.product_requester_domain.domain.entity.Product;
import com.kh0ma.product_requester_domain.domain.entity.ProductCategory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Olexander Khomenko
 */

public final class ProductCategoryMapper {

    private ProductCategoryMapper() {
    }

    public static ProductCategoryDto domainToDto(final ProductCategory category) {
        ProductCategoryDto result = new ProductCategoryDto();

        result.setName(category.getName());
        result.setDescription(category.getDescription());

        return result;
    }

    public static ProductCategory dtoToDomain(final ProductCategoryDto categoryDto) {
        ProductCategory result = new ProductCategory();

        result.setName(categoryDto.getName());
        result.setDescription(categoryDto.getDescription());

        return result;
    }

    public static List<ProductCategoryDto> domainsToDto(final List<ProductCategory> list) {
        return list
                .stream()
                .map(ProductCategoryMapper::domainToDto)
                .collect(Collectors.toList());
    }
}
