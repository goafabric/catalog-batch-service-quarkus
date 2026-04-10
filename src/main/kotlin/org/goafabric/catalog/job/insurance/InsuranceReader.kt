package org.goafabric.catalog.job.insurance

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import org.goafabric.catalog.job.AbstractCsvItemReader

@ApplicationScoped
@Named
class InsuranceReader : AbstractCsvItemReader<InsuranceEo>() {
    override fun map(
        tokens: List<String>,
        lineNumber: Long
    ): InsuranceEo {
        return InsuranceEo(
            id = null,
            code = tokens[0],
            display = tokens[1],
            shortname = tokens[2]
        )
    }
}