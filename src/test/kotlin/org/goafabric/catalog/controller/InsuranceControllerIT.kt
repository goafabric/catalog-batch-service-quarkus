package org.goafabric.catalog.controller

import io.quarkus.test.junit.QuarkusTest
import jakarta.inject.Inject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@QuarkusTest
class InsuranceControllerIT {
    @Inject
    lateinit var insuranceController: InsuranceController

    @Test
    fun findByCode() {
        assertThat(insuranceController.findByCode("168141347")).isNotNull()
    }

    @Test
    fun findByDisplay() {
        assertThat(insuranceController.findByDisplay("a")).isNotNull().isNotEmpty()
    }

}