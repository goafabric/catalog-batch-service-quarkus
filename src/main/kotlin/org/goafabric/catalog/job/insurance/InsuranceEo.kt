package org.goafabric.catalog.job.insurance

import jakarta.persistence.*

@Table(name = "condition")
@Entity
data class InsuranceEo(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: String?,

    var code: String,
    var display: String,
    var shortname: String
)