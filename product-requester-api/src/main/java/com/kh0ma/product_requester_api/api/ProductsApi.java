package com.kh0ma.product_requester_api.api;

import com.kh0ma.product_requester_api.dto.Product;

import javax.ws.rs.*;
import java.math.BigDecimal;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author Olexander Khomenko
 */

@Path("/product_categories/{category_id}/products")
public interface ProductsApi {

    @DELETE
    @Path("/{id}")
    void deleteProduct(
            @PathParam("category_id") Long categoryId,
            @PathParam("id") Long id);

    @GET
    @Produces(APPLICATION_JSON)
    List<Product> getProducts(
            @PathParam("category_id") Long categoryId,
            @QueryParam("name") String name,
            @QueryParam("price_from") BigDecimal priceFrom,
            @QueryParam("price_to") BigDecimal priceTo,
            @QueryParam("description") String description);

    @GET
    @Path("/{id}")
    Product getProduct(
            @PathParam("category_id") Long categoryId,
            @PathParam("id") Long id);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Product saveProduct(
            @PathParam("category_id") Long categoryId,
            Product product);

    @PUT
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    void updateProduct(
            @PathParam("category_id") Long categoryId,
            @PathParam("id") Long id,
            Product product);
}
