package org.goafabric.catalog.job

import io.quarkus.test.junit.QuarkusTest
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@QuarkusTest
@Tag("db-gen")
class CatalogDbGenerator {

    @Test
    fun generate() {
        // DB is populated on startup via JobLauncherStarter observing StartupEvent
    }

}
