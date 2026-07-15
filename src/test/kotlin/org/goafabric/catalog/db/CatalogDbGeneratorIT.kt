package org.goafabric.catalog.db

import io.quarkus.test.junit.QuarkusTest
import jakarta.inject.Inject
import org.goafabric.catalog.db.importer.ChargeItemImporter
import org.goafabric.catalog.db.importer.ConditionImporter
import org.goafabric.catalog.db.importer.InsuranceImporter
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@QuarkusTest
@Tag("db-gen")
class CatalogDbGeneratorIT {

    @Inject lateinit var chargeItemImporter: ChargeItemImporter
    @Inject lateinit var conditionImporter: ConditionImporter
    @Inject lateinit var insuranceImporter: InsuranceImporter

    @Test
    fun generate() {
        chargeItemImporter.import()
        conditionImporter.import()
        insuranceImporter.import()
    }
}
