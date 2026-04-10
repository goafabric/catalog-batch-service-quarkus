package org.goafabric.catalog.job.condition

import jakarta.persistence.*

@Table(name = "condition")
@Entity
data class ConditionEo(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String?,

    var code: String,
    var display: String,
    var shortname: String
)