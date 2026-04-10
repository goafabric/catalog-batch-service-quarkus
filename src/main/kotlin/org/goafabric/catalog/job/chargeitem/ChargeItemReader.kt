package org.goafabric.catalog.job.chargeitem

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import org.goafabric.catalog.job.AbstractCsvItemReader

@ApplicationScoped
@Named
class ChargeItemReader : AbstractCsvItemReader<ChargeItemEo>() {
    override fun map(
        tokens: List<String>,
        lineNumber: Long
    ): ChargeItemEo {
        return ChargeItemEo(
            id = null,
            code = tokens[0],
            display = tokens[1],
            price = tokens[2].toDouble()
        )
    }
}