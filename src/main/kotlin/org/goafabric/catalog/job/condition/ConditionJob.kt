package org.goafabric.catalog.job.condition

import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Produces
import jakarta.inject.Named
import org.jberet.job.model.Job
import org.jberet.job.model.JobBuilder
import org.jberet.job.model.StepBuilder

@ApplicationScoped
class ConditionJob {

    @Produces
    @Named
    fun conditionJob() : Job {
        return JobBuilder("conditionJob")
            .step(
                StepBuilder("conditionStep")
                    .reader("conditionReader")
                    .writer("conditionWriter")
                    .listener("stepCompletionListener")
                    .property("filename", "classpath:catalogs/icd10.csv")
                    .build()
            )
            .build()
    }
}