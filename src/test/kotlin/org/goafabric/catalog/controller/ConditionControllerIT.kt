package org.goafabric.catalog.controller

import io.quarkus.test.junit.QuarkusTest
import jakarta.inject.Inject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@QuarkusTest
class ConditionControllerIT {
    @Inject
    lateinit var conditionController: ConditionController

    @Test
    fun findByCode() {
        assertThat(conditionController.findByCode("E66.00")).isNotNull()
    }

    @Test
    fun findByDisplay() {
        assertThat(conditionController.findByDisplay("a")).isNotNull().isNotEmpty()
    }

}