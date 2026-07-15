package org.goafabric.catalog.db.importer

import jakarta.enterprise.context.ApplicationScoped
import jakarta.inject.Inject
import jakarta.transaction.Transactional
import org.apache.commons.csv.CSVRecord
import org.goafabric.catalog.persistence.condition.ConditionEo
import org.goafabric.catalog.persistence.condition.ConditionRepository

@ApplicationScoped
class ConditionImporter : CsvImporter<ConditionEo>(resource = "classpath:catalogs/icd10.csv") {

    @Inject lateinit var repository: ConditionRepository

    override fun map(record: CSVRecord) = ConditionEo(
        id        = null,
        code      = record[0],
        display   = record[1],
        shortname = record[2]
    )

    @Transactional
    override fun persist(items: List<ConditionEo>) = items.forEach(repository::save)
}
