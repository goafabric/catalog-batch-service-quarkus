package org.goafabric.catalog

import io.quarkus.runtime.Quarkus
import io.quarkus.runtime.annotations.QuarkusMain

@QuarkusMain
//@RegisterForReflection(targets = [IllegalArgumentException::class, InsuranceEo::class, ChargeItemEo::class, ConditionEo::class])
class Application
fun main(args: Array<String>) {
    Quarkus.run(*args)
}
