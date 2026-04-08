package org.goafabric.catalog.job.simpleitem

import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Produces
import jakarta.inject.Named
import org.jberet.job.model.Job
import org.jberet.job.model.JobBuilder
import org.jberet.job.model.StepBuilder

@ApplicationScoped
class SimpleItemJob {

    @Produces
    @Named
    fun simpleItemJob() : Job {
        return JobBuilder("simpleItemJob")
            .step(
                StepBuilder("simpleItemStep")
                    .reader("simpleItemReader")
                    .writer("simpleItemWriter")
                    .property("myProperty", "prop1")
                    .listener("stepCompletionListener")
                    .build()
            )
            .build()
    }
}