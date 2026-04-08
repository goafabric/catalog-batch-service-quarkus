package org.goafabric.catalog.job.chargeitem

import jakarta.batch.api.chunk.AbstractItemWriter
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import jakarta.transaction.Transactional

@ApplicationScoped
@Named
@Transactional
class ChargeItemWriter(
    private val chargeItemRepository: ChargeItemRepository) : AbstractItemWriter() {

    override fun writeItems(chargeItems: List<Any>) {
        //chargeItems.forEach { chargeItem -> chargeItemRepository.save(chargeItem as ChargeItemEo) }
    }
}