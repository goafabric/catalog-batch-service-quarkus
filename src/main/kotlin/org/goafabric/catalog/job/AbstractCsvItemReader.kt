package org.goafabric.catalog.job

import jakarta.batch.api.BatchProperty
import jakarta.batch.api.chunk.AbstractItemReader
import jakarta.inject.Inject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.Serializable
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path

abstract class AbstractCsvItemReader<T> : AbstractItemReader() {

    @Inject
    @BatchProperty(name = "filename")
    private var resource: String = "classpath:catalogs/goae.csv"

    @Inject
    @BatchProperty(name = "delimiter")
    private var delimiter: String? = ";"

    @Inject
    @BatchProperty(name = "skipHeader")
    private var skipHeader: String? = "false"

    private lateinit var reader: BufferedReader
    private var lineNumber: Long = 0

    override fun open(checkpoint: Serializable?) {
        val inputStream = openResource(resource)

        reader = BufferedReader(InputStreamReader(inputStream, StandardCharsets.UTF_8))

        if (skipHeader?.toBoolean() == true) {
            reader.readLine()
            lineNumber++
        }

        // restore checkpoint
        if (checkpoint is Long) {
            repeat(checkpoint.toInt()) {
                reader.readLine()
            }
            lineNumber = checkpoint
        }
    }

    override fun readItem(): T? {
        val line = reader.readLine() ?: return null
        lineNumber++

        val tokens = tokenize(line, delimiter ?: ",")

        return map(tokens, lineNumber)
    }

    override fun checkpointInfo(): Serializable {
        return lineNumber
    }

    override fun close() {
        reader.close()
    }

    /**
     * Override this to map tokens → domain object
     */
    protected abstract fun map(tokens: List<String>, lineNumber: Long): T

    /**
     * Override if you want custom parsing (quotes, escaping, etc.)
     */
    protected open fun tokenize(line: String, delimiter: String): List<String> {
        return line.split(delimiter)
    }

    private fun openResource(resource: String) =
        if (resource.startsWith("classpath:")) {
            val path = resource.removePrefix("classpath:")
            Thread.currentThread()
                .contextClassLoader
                .getResourceAsStream(path)
                ?: throw IllegalArgumentException("Classpath resource not found: $path")
        } else {
            Files.newInputStream(Path.of(resource))
        }
}