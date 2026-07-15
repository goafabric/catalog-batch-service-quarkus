package org.goafabric.catalog.job.condition

import jakarta.batch.api.chunk.AbstractItemWriter
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import jakarta.transaction.Transactional
import org.goafabric.catalog.persistence.condition.ConditionEo
import org.goafabric.catalog.persistence.condition.ConditionRepository

@ApplicationScoped
@Named
@Transactional
class ConditionWriter(
    private val conditionRepository: ConditionRepository
) : AbstractItemWriter() {

    override fun writeItems(conditions: List<Any>) {
        conditions.forEach { condition -> conditionRepository.save(condition as ConditionEo) }
    }
}