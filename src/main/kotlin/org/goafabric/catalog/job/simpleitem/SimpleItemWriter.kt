package org.goafabric.catalog.job.simpleitem

import jakarta.batch.api.chunk.AbstractItemWriter
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named

@ApplicationScoped
@Named
class SimpleItemWriter : AbstractItemWriter() {

    override fun writeItems(items: List<Any>) {
        items.forEach { item -> println(item) }
    }
}