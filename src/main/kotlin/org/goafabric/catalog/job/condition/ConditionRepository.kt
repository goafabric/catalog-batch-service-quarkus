package org.goafabric.catalog.job.condition

import io.quarkus.data.hibernate.ManagedRepository
import jakarta.data.repository.Find
import jakarta.data.repository.Query

interface ConditionRepository : ManagedRepository.CustomId<ConditionEo, String> {
    @Find
    fun findByCode(code: String): ConditionEo

    @Query("SELECT c FROM ConditionEo c WHERE LOWER(c.display) LIKE LOWER(CONCAT(:display, '%'))")
    fun findByDisplayStartsWith(display: String): List<ConditionEo>

    fun save(condition: ConditionEo): ConditionEo = session.merge(condition)
}