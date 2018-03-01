package com.kh0ma.product_requester_api.api;

import com.kh0ma.product_requester_api.dto.Invoice;

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
    List<Invoice> getInvoices(
            @PathParam("subscription_id") Long subscriptionId,
            @QueryParam("balance_from") BigDecimal balanceFrom,
            @QueryParam("balance_to") BigDecimal balanceTo,
            @QueryParam("bill_cycle_id") Long billCycleId);

    @GET
    @Path("/{id}")
    Invoice getInvoice(
            @PathParam("subscription_id") Long subscriptionId,
            @PathParam("id") Long Id);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    Invoice saveInvoice(
            @PathParam("subscription_id") Long subscriptionId,
            Invoice invoice);

    @PUT
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    void updateInvoice(
            @PathParam("subscription_id") Long subscriptionId,
            @PathParam("id") Long Id,
            Invoice invoice);
}
