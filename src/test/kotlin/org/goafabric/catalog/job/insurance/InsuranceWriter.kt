package org.goafabric.catalog.job.insurance

import jakarta.batch.api.chunk.AbstractItemWriter
import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import jakarta.transaction.Transactional
import org.goafabric.catalog.persistence.insurance.InsuranceEo
import org.goafabric.catalog.persistence.insurance.InsuranceRepository

@ApplicationScoped
@Named
@Transactional
class InsuranceWriter(
    private val insuranceRepository: InsuranceRepository
) : AbstractItemWriter() {

    override fun writeItems(insurances: List<Any>) {
        insurances.forEach { insurance -> insuranceRepository.save(insurance as InsuranceEo) }
    }
}