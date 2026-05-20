package org.goafabric.catalog.controller

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.goafabric.catalog.job.insurance.InsuranceEo
import org.goafabric.catalog.job.insurance.InsuranceRepository

@Path("/insurances")
@Produces(MediaType.APPLICATION_JSON)
class InsuranceController(private val repository: InsuranceRepository) {
    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: String): InsuranceEo {
        return repository.findById(id)
    }

    @GET
    @Path("/findByCode")
    fun findByCode(@QueryParam("code") code: String): InsuranceEo {
        return repository.findByCode(code)
    }

    @GET
    @Path("/findByDisplay")
    fun findByDisplay(@QueryParam("display") display: String): List<InsuranceEo> {
        return repository.findByDisplayStartsWith(display)
    }
}
