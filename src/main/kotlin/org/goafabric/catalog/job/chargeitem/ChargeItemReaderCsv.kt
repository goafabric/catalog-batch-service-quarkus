package org.goafabric.catalog.job.chargeitem

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Named
import org.goafabric.catalog.job.AbstractCsvItemReader

@ApplicationScoped
@Named
class ChargeItemReaderCsv : AbstractCsvItemReader<ChargeItemEo>() {
    override fun map(
        tokens: List<String>,
        lineNumber: Long
    ): ChargeItemEo {
        return ChargeItemEo(
            id = null,
            code = tokens.getOrNull(0)?.trim().orEmpty(),
            display = tokens.getOrNull(1)?.trim().orEmpty(),
            price = tokens.getOrNull(2)?.trim()?.toDoubleOrNull() ?: 0.0
        )
    }
}