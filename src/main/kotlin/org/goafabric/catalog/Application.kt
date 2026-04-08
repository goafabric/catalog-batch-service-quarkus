package org.goafabric.catalog

import io.quarkus.runtime.Quarkus
import io.quarkus.runtime.QuarkusApplication
import io.quarkus.runtime.annotations.QuarkusMain
import jakarta.inject.Inject
import org.goafabric.catalog.job.JobLauncherStarter

@QuarkusMain
class Application
/*
    : QuarkusApplication {
    @Inject
    lateinit var runner: JobLauncherStarter

    
    override fun run(vararg args: String?): Int {
        //runner.run()
        return 0
    }

}

 */

fun main(args: Array<String>) {
    Quarkus.run(*args)
}
