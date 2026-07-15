package org.goafabric.catalog.job.chargeitem

import jakarta.batch.api.chunk.AbstractItemWriter
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import jakarta.transaction.Transactional
import org.goafabric.catalog.persistence.chargeitem.ChargeItemEo
import org.goafabric.catalog.persistence.chargeitem.ChargeItemRepository

@ApplicationScoped
@Named
@Transactional
class ChargeItemWriter(
    private val chargeItemRepository: ChargeItemRepository
) : AbstractItemWriter() {

    override fun writeItems(chargeItems: List<Any>) {
        chargeItems.forEach { chargeItem -> chargeItemRepository.save(chargeItem as ChargeItemEo) }
    }
}