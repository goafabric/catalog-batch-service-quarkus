package org.goafabric.catalog.controller

import jakarta.inject.Inject
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ChargeItemControllerIT {
    @Inject
    lateinit var chargeItemController: ChargeItemController

    @Test
    fun findByCode() {
        assertThat(chargeItemController.findByCode("GOAE1")).isNotNull()
    }

    @Test
    fun findByDisplay() {
        assertThat(chargeItemController.findByDisplay("")).isNotNull().isNotEmpty()
    }

}