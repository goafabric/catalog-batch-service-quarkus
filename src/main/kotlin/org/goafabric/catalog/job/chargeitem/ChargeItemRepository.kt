package org.goafabric.catalog.job.chargeitem

import io.quarkus.data.hibernate.ManagedRepository
import jakarta.data.repository.Find
import jakarta.data.repository.Query

interface ChargeItemRepository : ManagedRepository.CustomId<ChargeItemEo, String> {
    @Find
    fun findByCode(code: String): ChargeItemEo

    @Query("SELECT c FROM ChargeItemEo c WHERE LOWER(c.display) LIKE LOWER(CONCAT(:display, '%'))")
    fun findByDisplayStartsWith(display: String): List<ChargeItemEo>

    fun save(chargeItem: ChargeItemEo): ChargeItemEo = session.merge(chargeItem)
}