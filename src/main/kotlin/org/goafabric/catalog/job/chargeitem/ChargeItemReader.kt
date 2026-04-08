package org.goafabric.catalog.job.chargeitem

import jakarta.batch.api.chunk.AbstractItemReader
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named

@ApplicationScoped
@Named
class ChargeItemReader : AbstractItemReader() {
    private val simpleItems = listOf(ChargeItemEo(null, "GOA1", "text", 50.0))
    private var index = 0

    override fun readItem(): ChargeItemEo? {
        return simpleItems.getOrNull(index++)
    }
}