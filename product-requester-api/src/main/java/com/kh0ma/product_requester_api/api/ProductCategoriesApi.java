package com.kh0ma.product_requester_api.api;

import com.kh0ma.product_requester_api.dto.ProductCategory;

import javax.ws.rs.*;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/product_categories")
public interface ProductCategoriesApi {

    @DELETE
    @Path("/{category_id}")
    void deleteProductCategory(
            @PathParam("category_id") Long categoryId);

    @GET
    @Produces(APPLICATION_JSON)
    List<ProductCategory> getProductCategories(
            @QueryParam("name") String name,
            @QueryParam("description") String description);

    @GET
    @Path("/{category_id}")
    ProductCategory getProductCategory(
            @PathParam("category_id") Long categoryId);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    ProductCategory saveProductCategory(
            ProductCategory productCategory);

    @PUT
    @Path("/{category_id}")
    @Consumes(APPLICATION_JSON)
    void updateProductCategory(
            @PathParam("category_id") Long categoryId,
            ProductCategory productCategory);
}
