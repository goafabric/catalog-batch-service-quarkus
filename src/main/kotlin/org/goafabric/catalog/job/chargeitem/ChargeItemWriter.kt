package org.goafabric.catalog.job.chargeitem

import jakarta.batch.api.chunk.AbstractItemWriter
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named

@ApplicationScoped
@Named("chargeItemWriter")
class ChargeItemWriter : AbstractItemWriter() {

    override fun writeItems(items: List<Any>) {
        items.forEach { item -> println(item) }
    }
}