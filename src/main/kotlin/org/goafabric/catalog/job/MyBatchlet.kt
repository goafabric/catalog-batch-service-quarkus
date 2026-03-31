package org.goafabric.catalog.job

import jakarta.batch.api.AbstractBatchlet
import jakarta.batch.runtime.BatchStatus
import jakarta.inject.Named

@Named
class MyBatchlet : AbstractBatchlet() {
    override fun process(): String {
        println("yolo")
        return BatchStatus.COMPLETED.toString()
    }
}