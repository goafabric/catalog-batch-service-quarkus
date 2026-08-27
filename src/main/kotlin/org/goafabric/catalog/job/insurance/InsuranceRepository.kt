package org.goafabric.catalog.job.insurance

import io.quarkus.data.hibernate.ManagedRepository
import jakarta.data.repository.Find
import jakarta.data.repository.Query

interface InsuranceRepository : ManagedRepository.CustomId<InsuranceEo, String> {
    @Find
    fun findByCode(code: String): InsuranceEo

    @Query("SELECT c FROM InsuranceEo c WHERE LOWER(c.display) LIKE LOWER(CONCAT(:display, '%'))")
    fun findByDisplayStartsWith(display: String): List<InsuranceEo>

    fun save(insurance: InsuranceEo): InsuranceEo = session.merge(insurance)
}