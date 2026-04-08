package org.goafabric.catalog.job.chargeitem

import jakarta.batch.api.chunk.AbstractItemWriter
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional

@ApplicationScoped
@Named
@Transactional
class ChargeItemWriter(
    private val entityManager: EntityManager) : AbstractItemWriter() {

    override fun writeItems(chargeItems: List<Any>) {
        println("yolo")
        chargeItems.forEach { chargeItem -> entityManager.persist(chargeItem as ChargeItemEo) }
    }
}