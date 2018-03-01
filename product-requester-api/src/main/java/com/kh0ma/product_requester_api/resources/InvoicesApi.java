package com.kh0ma.product_requester_api.resources;

import com.kh0ma.product_requester_api.dto.Invoicedto;

import javax.ws.rs.*;
import java.math.BigDecimal;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author Olexander Khomenko
 */

@Path("/subscriptions/{subscription_id}/invoices")
public interface InvoicesApi {

    @DELETE
    @Path("/{id}")
    void deleteInvoice(
            @PathParam("subscription_id") Long subscriptionId,
            @PathParam("id") Long Id);

    @GET
    @Produces(APPLICATION_JSON)
    List<Invoicedto> getInvoices(
            @PathParam("subscription_id") Long subscriptionId,
            @QueryParam("balance_from") BigDecimal balanceFrom,
            @QueryParam("balance_to") BigDecimal balanceTo,
            @QueryParam("bill_cycle_id") Long billCycleId);

    @GET
    @Path("/{id}")
    Invoicedto getInvoice(
            @PathParam("subscription_id") Long subscriptionId,
            @PathParam("id") Long Id);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Invoicedto saveInvoice(
            @PathParam("subscription_id") Long subscriptionId,
            Invoicedto invoicedto);

    @PUT
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    void updateInvoice(
            @PathParam("subscription_id") Long subscriptionId,
            @PathParam("id") Long Id,
            Invoicedto invoicedto);
}
