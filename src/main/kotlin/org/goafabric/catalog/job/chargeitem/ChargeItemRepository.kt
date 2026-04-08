package org.goafabric.catalog.job.chargeitem

import io.quarkus.hibernate.panache.PanacheRepository
import org.hibernate.annotations.processing.Find

interface ChargeItemRepository : PanacheRepository.Managed<ChargeItemEo, String> {
    @Find
    fun getById(id: String): ChargeItemEo

    fun save(chargeItem: ChargeItemEo) {
        session.merge(chargeItem)
    }
}