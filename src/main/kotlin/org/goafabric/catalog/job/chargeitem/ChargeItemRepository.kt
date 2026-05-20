package org.goafabric.catalog.job.chargeitem

import io.quarkus.hibernate.panache.PanacheRepository
import jakarta.data.repository.Find

interface ChargeItemRepository : PanacheRepository.Managed<ChargeItemEo, String> {
    @Find
    fun findByCode(code: String): ChargeItemEo

    @Find
    fun findByDisplay(display: String): List<ChargeItemEo>

    fun save(chargeItem: ChargeItemEo): ChargeItemEo {
        return session.merge(chargeItem)
    }
}