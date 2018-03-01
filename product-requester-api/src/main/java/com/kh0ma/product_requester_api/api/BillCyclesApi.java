package com.kh0ma.product_requester_api.api;

import com.kh0ma.product_requester_api.dto.BillCycle;

import javax.ws.rs.*;

import java.time.LocalDate;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/bill_cycles")
public interface BillCyclesApi {

    @DELETE
    @Path("/{bill_cycle_id}")
    void deleteBillCycle(
            @PathParam("bill_cycle_id") Long billCycleId);

    @GET
    @Produces(APPLICATION_JSON)
    List<BillCycle> getBillCycles(
            @QueryParam("status") String status,
            @QueryParam("valid_from") LocalDate validFrom,
            @QueryParam("valid_to") LocalDate validTo);

    @GET
    @Path("/{bill_cycle_id}")
    BillCycle getBillCycle(
            @PathParam("bill_cycle_id") Long billCycleId);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    BillCycle saveBillCycle(
            BillCycle billCycle);

    @PUT
    @Path("/{bill_cycle_id}")
    @Consumes(APPLICATION_JSON)
    void updateBillCycle(
            @PathParam("bill_cycle_id") Long billCycleId,
            BillCycle billCycle);
}

