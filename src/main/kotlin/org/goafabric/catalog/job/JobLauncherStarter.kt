package org.goafabric.catalog.job

import jakarta.batch.operations.JobOperator
import jakarta.enterprise.context.ApplicationScoped
import java.util.Properties

@ApplicationScoped
class JobLauncherStarter(private val jobOperator: JobOperator) {

    fun run() {
        //jobOperator.start("myJob", Properties())
        jobOperator.start("simpleItemJob", Properties())
    }
}