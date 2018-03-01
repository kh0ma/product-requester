package com.kh0ma.product_requester_api.api;

import com.kh0ma.product_requester_api.dto.Subscription;

import javax.ws.rs.*;
import java.time.LocalDate;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/subscriptions")
public interface SubscriptionsApi {

    @DELETE
    @Path("/{subscription_id}")
    void deleteSubscription(
            @PathParam("subscription_id") Long subscriptionId);

    @GET
    @Produces(APPLICATION_JSON)
    List<Subscription> getSubscriptions(
            @QueryParam("status") String status,
            @QueryParam("valid_from") LocalDate validFrom,
            @QueryParam("valid_to") LocalDate validTo,
            @QueryParam("product_id") Long productId,
            @QueryParam("bill_cycle_id") Long billCycleId);

    @GET
    @Path("/{subscription_id}")
    Subscription getSubscription(
            @PathParam("subscription_id") Long subscriptionId);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Subscription saveSubscription(
            Subscription subscription);

    @PUT
    @Path("/{subscription_id}")
    @Consumes(APPLICATION_JSON)
    void updateSubscription(
            @PathParam("subscription_id") Long subscriptionId,
            Subscription subscription);
}
