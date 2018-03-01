package com.kh0ma.product_requester_api.api;

import com.kh0ma.product_requester_api.dto.BillCycleRun;

import javax.ws.rs.*;
import java.time.LocalDate;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * @author Olexander Khomenko
 */

@Path("/bill_cycles/{bill_cycle_id}/bill_cycle_runs/")
public interface BillCycleRunsApi {

    @DELETE
    @Path("/{id}")
    void deleteBillCycleRun(
            @PathParam("bill_cycle_id") Long billCycleId,
            @PathParam("id") Long id);

    @GET
    @Produces(APPLICATION_JSON)
    List<BillCycleRun> getBillCycleRuns(
            @PathParam("bill_cycle_id") Long billCycleId,
            @QueryParam("status") String status,
            @QueryParam("start_date") LocalDate startDate,
            @QueryParam("end_date") LocalDate endDate);

    @GET
    @Path("/{id}")
    BillCycleRun getBillCycleRun(
            @PathParam("bill_cycle_id") Long billCycleId,
            @PathParam("id") Long id);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    BillCycleRun saveBillCycleRun(
            @PathParam("bill_cycle_id") Long billCycleId,
            BillCycleRun billCycle);

    @PUT
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    void updateBillCycleRun(
            @PathParam("bill_cycle_id") Long billCycleId,
            @PathParam("id") Long id,
            BillCycleRun billCycle);
}
