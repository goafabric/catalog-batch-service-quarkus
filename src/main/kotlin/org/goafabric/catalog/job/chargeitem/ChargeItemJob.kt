package org.goafabric.catalog.job.chargeitem

import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Produces
import jakarta.inject.Named
import org.jberet.job.model.Job
import org.jberet.job.model.JobBuilder
import org.jberet.job.model.StepBuilder

@ApplicationScoped
class ChargeItemJob {

    @Produces
    @Named
    fun chargeItemJob() : Job {
        return JobBuilder("chargeItemJob")
            .step(
                StepBuilder("chargeItemStep")
                    .reader("chargeItemReaderCsv")
                    .writer("chargeItemWriter")
                    .listener("stepCompletionListener")
                    .property("filename", "classpath:catalogs/goae.csv")
                    .build()
            )
            .build()
    }
}