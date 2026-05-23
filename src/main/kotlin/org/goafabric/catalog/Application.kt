package org.goafabric.catalog

import io.quarkus.runtime.Quarkus
import io.quarkus.runtime.annotations.QuarkusMain
import io.quarkus.runtime.annotations.RegisterForReflection
import org.goafabric.catalog.job.chargeitem.ChargeItemEo
import org.goafabric.catalog.job.condition.ConditionEo
import org.goafabric.catalog.job.insurance.InsuranceEo

@QuarkusMain
@RegisterForReflection(targets = [IllegalArgumentException::class, InsuranceEo::class, ChargeItemEo::class, ConditionEo::class])
class Application
fun main(args: Array<String>) {
    Quarkus.run(*args)
}
