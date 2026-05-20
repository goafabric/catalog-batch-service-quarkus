package org.goafabric.catalog.job

import io.quarkus.arc.All
import io.quarkus.runtime.StartupEvent
import jakarta.batch.operations.JobOperator
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Observes
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.jberet.job.model.Job
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*
import kotlin.system.exitProcess

@ApplicationScoped
class JobLauncherStarter(private val jobOperator: JobOperator,
           @param:All private val jobs: MutableList<Job>,
           @param:ConfigProperty(name = "database.provisioning.goals") private val goals: String) {

    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    fun onStart(@Observes ev: StartupEvent) {
        run()
    }

    fun run() {
        if (goals.contains("-import-catalog-data")) {
            jobs.forEach {
                job -> jobOperator.start(job.id, Properties())
                log.info("starting job {}", job.id)
            }
        }

        if (goals.contains("-terminate")) {
            log.info("Terminating app ...")
            exitProcess(0)
        }
    }
}