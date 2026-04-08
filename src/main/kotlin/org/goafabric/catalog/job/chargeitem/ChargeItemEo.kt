package org.goafabric.catalog.job.chargeitem

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "chargeitem", schema = "public")
@Entity
data class ChargeItemEo(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String?,

    var code: String,
    var display: String,
    var price: Double
)