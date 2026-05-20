package org.goafabric.catalog.controller

import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.goafabric.catalog.job.chargeitem.ChargeItemEo
import org.goafabric.catalog.job.chargeitem.ChargeItemRepository

@Path("/chargeitems")
@Produces(MediaType.APPLICATION_JSON)
class ChargeItemController(private val repository: ChargeItemRepository) {
    @GET
    @Path("/{id}")
    fun getById(@PathParam("id") id: String): ChargeItemEo {
        return repository.findById(id)
    }

    @GET
    @Path("/findByCode")
    fun findByCode(@QueryParam("code") code: String): ChargeItemEo {
        return repository.findByCode(code)
    }

    @GET
    @Path("/findByDisplay")
    fun findByDisplay(@QueryParam("display") display: String): List<ChargeItemEo> {
        return repository.findByDisplayStartsWith(display)
    }
}
