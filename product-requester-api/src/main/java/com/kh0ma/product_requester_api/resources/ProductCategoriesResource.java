package com.kh0ma.product_requester_api.resources;

import com.kh0ma.product_requester_api.dto.ProductCategoryDto;
import com.kh0ma.product_requster_core.service.ProductCategoriesService;

import javax.ws.rs.*;
import java.util.List;

import static com.kh0ma.product_requester_api.mappers.ProductCategoryMapper.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author Olexander Khomenko
 */

@Path("/product_categories")
public class ProductCategoriesResource {

    private final ProductCategoriesService service;

    public ProductCategoriesResource(ProductCategoriesService service) {
        this.service = service;
    }

    @DELETE
    @Path("/{category_id}")
    public void deleteProductCategory(
            @PathParam("category_id") Long categoryId) {
        service.delete(categoryId);
    }

    @GET
    @Produces(APPLICATION_JSON)
    public List<ProductCategoryDto> getProductCategories(
            @QueryParam("name") String name,
            @QueryParam("description") String description) {
        return domainsToDto(service.findAll());
    }

    @GET
    @Path("/{category_id}")
    @Produces(APPLICATION_JSON)
    public ProductCategoryDto getProductCategory(
            @PathParam("category_id") Long categoryId) {
        return domainToDto(service.findOne(categoryId));
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public ProductCategoryDto saveProductCategory(
            ProductCategoryDto productCategoryDto) {
        return domainToDto(
                service.save(dtoToDomain(productCategoryDto))
        );
    }

    @PUT
    @Path("/{category_id}")
    @Consumes(APPLICATION_JSON)
    public void updateProductCategory(
            @PathParam("category_id") Long categoryId,
            ProductCategoryDto productCategoryDto) {
        service.update(categoryId, dtoToDomain(productCategoryDto));
    }
}
