package org.goafabric.catalog.job.insurance

import jakarta.enterprise.context.ApplicationScoped
import jakarta.enterprise.inject.Produces
import jakarta.inject.Named
import org.jberet.job.model.Job
import org.jberet.job.model.JobBuilder
import org.jberet.job.model.StepBuilder

@ApplicationScoped
class InsuranceJob {

    @Produces
    @Named
    fun insuranceJob() : Job {
        return JobBuilder("insuranceJob")
            .step(
                StepBuilder("insuranceStep")
                    .reader("insuranceReader")
                    .writer("insuranceWriter")
                    .listener("stepCompletionListener")
                    .property("filename", "classpath:catalogs/insurance_pkv.csv")
                    .build()
            )
            .build()
    }
}