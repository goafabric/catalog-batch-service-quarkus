package org.goafabric.catalog.job.insurance

import jakarta.batch.api.chunk.AbstractItemWriter
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import jakarta.persistence.EntityManager
import jakarta.transaction.Transactional

@ApplicationScoped
@Named
@Transactional
class InsuranceWriter(
    private val entityManager: EntityManager) : AbstractItemWriter() {

    override fun writeItems(insurances: List<Any>) {

        insurances.forEach { insurance -> entityManager.persist(insurance as InsuranceEo) }
        insurances.forEach { insurance -> println("#insurance $insurance") }
    }
}