package com.kh0ma.product_requester_api.resources;

import com.kh0ma.product_requester_api.dto.BillCycleRunDto;

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
    List<BillCycleRunDto> getBillCycleRuns(
            @PathParam("bill_cycle_id") Long billCycleId,
            @QueryParam("status") String status,
            @QueryParam("start_date") LocalDate startDate,
            @QueryParam("end_date") LocalDate endDate);

    @GET
    @Path("/{id}")
    BillCycleRunDto getBillCycleRun(
            @PathParam("bill_cycle_id") Long billCycleId,
            @PathParam("id") Long id);

    @POST
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    BillCycleRunDto saveBillCycleRun(
            @PathParam("bill_cycle_id") Long billCycleId,
            BillCycleRunDto billCycle);

    @PUT
    @Path("/{id}")
    @Consumes(APPLICATION_JSON)
    void updateBillCycleRun(
            @PathParam("bill_cycle_id") Long billCycleId,
            @PathParam("id") Long id,
            BillCycleRunDto billCycle);
}
