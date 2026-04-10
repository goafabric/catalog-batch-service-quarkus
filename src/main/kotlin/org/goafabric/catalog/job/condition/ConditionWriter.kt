package org.goafabric.catalog.job.condition

import jakarta.batch.api.chunk.AbstractItemWriter
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional

@ApplicationScoped
@Named
@Transactional
class ConditionWriter(
    private val entityManager: EntityManager) : AbstractItemWriter() {

    override fun writeItems(conditions: List<Any>) {

        conditions.forEach { condition -> entityManager.persist(condition as ConditionEo) }
        conditions.forEach { condition -> println("#condition $condition") }
    }
}