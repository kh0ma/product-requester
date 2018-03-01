package com.kh0ma.product_requester_application;

import com.kh0ma.product_requester_api.resources.ProductCategoriesResource;
import com.kh0ma.product_requester_api.resources.ProductsResource;
import com.kh0ma.product_requster_core.service.ProductCategoriesService;
import com.kh0ma.product_requster_core.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Olexander Khomenko
 */
public class ProductRequesterMain {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext;
        applicationContext = new ClassPathXmlApplicationContext(
                "spring/spring-app.xml",
                "spring/spring-core.xml",
                "spring/spring-db.xml"
        );

        ProductService productService = applicationContext.getBean(ProductService.class);
        ProductCategoriesService pCategoriesService = applicationContext.getBean(ProductCategoriesService.class);
        new ProductRequesterApplication(new ProductCategoriesResource(pCategoriesService), new ProductsResource(productService)).run(args);
    }
}
