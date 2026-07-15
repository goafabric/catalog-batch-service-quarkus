package org.goafabric.catalog.db.importer

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import org.apache.commons.csv.CSVRecord
import org.goafabric.catalog.persistence.chargeitem.ChargeItemEo
import org.goafabric.catalog.persistence.chargeitem.ChargeItemRepository

@ApplicationScoped
class ChargeItemImporter : CsvImporter<ChargeItemEo>(resource = "classpath:catalogs/goae.csv") {

    @Inject lateinit var repository: ChargeItemRepository

    override fun map(record: CSVRecord) = ChargeItemEo(
        id      = null,
        code    = record[0],
        display = record[1],
        price   = record[2].toDouble()
    )

    @Transactional
    override fun persist(items: List<ChargeItemEo>) = items.forEach(repository::save)
}
