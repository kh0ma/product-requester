package com.kh0ma.product_requester_api.resources;

import com.kh0ma.product_requester_api.dto.ProductDto;
import com.kh0ma.product_requster_core.service.ProductService;

import javax.ws.rs.*;
import java.math.BigDecimal;
import java.util.List;

import static com.kh0ma.product_requester_api.mappers.ProductMapper.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author Olexander Khomenko
 */

@Path("/product_categories/{category_id}/products")
public class ProductsResource {

    private ProductService service;

    public ProductsResource(ProductService service) {
        this.service = service;
    }

    @DELETE
    @Path("/{id}")
    public void deleteProduct(
            @PathParam("category_id") Long categoryId,
            @PathParam("id") Long id) {
        service.delete(categoryId, id);
    }

    @GET
    @Produces(APPLICATION_JSON)
    public List<ProductDto> getProducts(
            @PathParam("category_id") Long categoryId,
            @QueryParam("name") String name,
            @QueryParam("price_from") BigDecimal priceFrom,
            @QueryParam("price_to") BigDecimal priceTo,
            @QueryParam("description") String description) {
        return domainsToDto(service.findAll(categoryId));
    }

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public ProductDto getProduct(
            @PathParam("category_id") Long categoryId,
            @PathParam("id") Long id) {
        return domainToDto(service.findOne(categoryId, id));
    }

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public ProductDto saveProduct(
            @PathParam("category_id") Long categoryId,
            ProductDto productDto) {
        return domainToDto(
                service.save(categoryId, dtoToDomain(productDto))
        );
    }

    @PUT
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    public void updateProduct(
            @PathParam("category_id") Long categoryId,
            @PathParam("id") Long id,
            ProductDto productDto) {
        service.update(categoryId, id, dtoToDomain(productDto));
    }
}
