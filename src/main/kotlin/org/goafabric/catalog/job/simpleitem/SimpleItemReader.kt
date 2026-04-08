package org.goafabric.catalog.job.simpleitem

import jakarta.batch.api.chunk.AbstractItemReader
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named

@ApplicationScoped
@Named//("simpleItemReader")
class SimpleItemReader : AbstractItemReader() {
    private val simpleItems = listOf("item1", "item2", "item3")
    private var index = 0

    override fun readItem(): String? {
        return simpleItems.getOrNull(index++)
    }
}