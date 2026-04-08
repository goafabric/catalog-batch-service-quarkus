package org.goafabric.catalog.controller

import jakarta.validation.Valid
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import org.goafabric.catalog.job.JobLauncherStarter

@Path("/start")
@Produces(MediaType.APPLICATION_JSON)
class PersonController(private val jobLauncherStarter: JobLauncherStarter) {
    @GET
    @Path("/")
    fun start() {
        return jobLauncherStarter.run()
    }

}
