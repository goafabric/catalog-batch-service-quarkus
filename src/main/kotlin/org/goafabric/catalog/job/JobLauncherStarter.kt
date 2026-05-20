package org.goafabric.catalog.job

import io.quarkus.arc.All
import io.quarkus.runtime.StartupEvent
import jakarta.batch.operations.JobOperator
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Observes
import org.jberet.job.model.Job
import java.util.*

@ApplicationScoped
class JobLauncherStarter(private val jobOperator: JobOperator, @param:All private val jobs: MutableList<Job>) {

    fun onStart(@Observes ev: StartupEvent) {
        run()
    }

    fun run() {
        jobs.forEach { job -> jobOperator.start(job.id, Properties()) }
    }
}