package org.goafabric.catalog.job

import jakarta.batch.api.listener.AbstractStepListener
import jakarta.batch.api.listener.StepListener
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@ApplicationScoped
@Named("stepCompletionListener")
class StepCompletionListener: StepListener {
    private val log: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun beforeStep() {
    }

    override fun afterStep() {
        log.info("step completed")
    }
}