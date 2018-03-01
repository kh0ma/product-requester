package com.kh0ma.product_requester_application;

import com.kh0ma.product_requester_api.resources.ProductCategoriesResource;
import com.kh0ma.product_requester_api.resources.ProductsResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * @author Olexander Khomenko
 */

public class ProductRequesterApplication extends Application<ProductRequesterConfiguration> {

    private final ProductCategoriesResource productCategoriesResource;
    private final ProductsResource productsResource;

    public ProductRequesterApplication(final ProductCategoriesResource productCategoriesResource,
                                       final ProductsResource productsResource) {
        this.productCategoriesResource = productCategoriesResource;
        this.productsResource = productsResource;
    }

    @Override
    public void initialize(Bootstrap<ProductRequesterConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets", "/swagger", "index.html"));
//        bootstrap.addBundle(new AssetsBundle("/META-INF/resources/webjars", "/webjarst"));
        bootstrap.addBundle(new AssetsBundle("/META-INF/resources/webjars", "/webjars", "", "webjars"));
    }

    @Override
    public void run(ProductRequesterConfiguration configuration,
                    Environment environment) {
        JerseyEnvironment jersey = environment.jersey();

        jersey.register(productCategoriesResource);
        jersey.register(productsResource);
    }

}
