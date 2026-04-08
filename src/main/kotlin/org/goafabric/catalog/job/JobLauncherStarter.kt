package org.goafabric.catalog.job

import io.quarkus.runtime.StartupEvent
import jakarta.batch.operations.JobOperator
import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.event.Observes
import java.util.Properties

@ApplicationScoped
class JobLauncherStarter(private val jobOperator: JobOperator) {

    fun onStart(@Observes ev: StartupEvent) {
        run()
    }

    fun run() {
        //jobOperator.start("simpleItemJob", Properties())
        jobOperator.start("chargeItemJob", Properties())
    }
}