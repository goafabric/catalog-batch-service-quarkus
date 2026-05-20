package org.goafabric.catalog.controller

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.goafabric.catalog.job.condition.ConditionEo
import org.goafabric.catalog.job.condition.ConditionRepository

@Path("/conditions")
@Produces(MediaType.APPLICATION_JSON)
class ConditionController(private val repository: ConditionRepository) {
    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: String): ConditionEo {
        return repository.findById(id)
    }

    @GET
    @Path("/findByCode")
    fun findByCode(@QueryParam("code") code: String): ConditionEo {
        return repository.findByCode(code)
    }

    @GET
    @Path("/findByDisplay")
    fun findByDisplay(@QueryParam("display") display: String): List<ConditionEo> {
        return repository.findByDisplayStartsWith(display)
    }
}
