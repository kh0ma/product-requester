package com.kh0ma.product_requester_api.resources;

import com.kh0ma.product_requester_api.dto.SubscriptionDto;

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
    List<SubscriptionDto> getSubscriptions(
            @QueryParam("status") String status,
            @QueryParam("valid_from") LocalDate validFrom,
            @QueryParam("valid_to") LocalDate validTo,
            @QueryParam("product_id") Long productId,
            @QueryParam("bill_cycle_id") Long billCycleId);

    @GET
    @Path("/{subscription_id}")
    SubscriptionDto getSubscription(
            @PathParam("subscription_id") Long subscriptionId);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    SubscriptionDto saveSubscription(
            SubscriptionDto subscriptionDto);

    @PUT
    @Path("/{subscription_id}")
    @Consumes(APPLICATION_JSON)
    void updateSubscription(
            @PathParam("subscription_id") Long subscriptionId,
            SubscriptionDto subscriptionDto);
}
