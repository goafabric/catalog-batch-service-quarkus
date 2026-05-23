package org.goafabric.catalog

import io.quarkus.runtime.Quarkus
import io.quarkus.runtime.annotations.QuarkusMain
import io.quarkus.runtime.annotations.RegisterForReflection

@QuarkusMain
@RegisterForReflection(targets = [IllegalArgumentException::class])
class Application
fun main(args: Array<String>) {
    Quarkus.run(*args)
}
