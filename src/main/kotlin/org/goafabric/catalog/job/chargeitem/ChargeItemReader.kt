package org.goafabric.catalog.job.chargeitem

import jakarta.batch.api.chunk.AbstractItemReader
import jakarta.batch.api.chunk.ItemReader
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import java.io.Serializable

@ApplicationScoped
@Named("chargeItemReader")
class ChargeItemReader : AbstractItemReader() {
    private val chargeItems = listOf("GOAE1", "GOAE2", "GOAE3")
    private var index = 0

    override fun readItem(): String? {
        return chargeItems.getOrNull(index++)
    }
}