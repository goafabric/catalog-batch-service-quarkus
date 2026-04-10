package org.goafabric.catalog.job.condition

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import org.goafabric.catalog.job.AbstractCsvItemReader

@ApplicationScoped
@Named
class ConditionReader : AbstractCsvItemReader<ConditionEo>() {
    override fun map(
        tokens: List<String>,
        lineNumber: Long
    ): ConditionEo {
        return ConditionEo(
            id = null,
            code = tokens[0],
            display = tokens[1],
            shortname = tokens[2]
        )
    }
}