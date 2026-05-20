package org.goafabric.catalog.controller

import io.quarkus.test.junit.QuarkusTest
import jakarta.inject.Inject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

@QuarkusTest
class ChargeItemControllerIT {
    @Inject
    lateinit var chargeItemController: ChargeItemController

    @Test
    fun findByCode() {
        assertThat(chargeItemController.findByCode("GOAE1")).isNotNull()
    }

    @Test
    fun findByDisplay() {
        assertThat(chargeItemController.findByDisplay("n")).isNotNull().isNotEmpty()
    }

}