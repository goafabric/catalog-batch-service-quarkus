package org.goafabric.catalog.job

import jakarta.enterprise.inject.Produces
import jakarta.inject.Named
import jakarta.inject.Singleton
import org.jberet.job.model.Job
import org.jberet.job.model.JobBuilder
import org.jberet.job.model.StepBuilder

@Singleton
class MyJob {

    @Produces
    @Named
    fun myJob() : Job {
        return JobBuilder("myJob")
            .step(
                StepBuilder("cleanupStep")
                .batchlet("myBatchlet")
                .property("directory", "/tmp/batch")
                .property("daysToKepp", "30")
                .build())
            .build();
    }
}