package org.goafabric.catalog.db.importer

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord
import org.slf4j.LoggerFactory
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path

abstract class CsvImporter<T>(
    private val resource: String,
    private val delimiter: Char = ';',
    private val skipHeader: Boolean = false,
    private val chunkSize: Int = 500
) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun import() {
        val format = CSVFormat.DEFAULT.builder()
            .setDelimiter(delimiter)
            .setSkipHeaderRecord(skipHeader)
            .setIgnoreEmptyLines(true)
            .setTrim(true)
            .build()

        openReader().use { reader ->
            val records = format.parse(reader)
            var chunk = mutableListOf<T>()
            var total = 0L

            for (record in records) {
                chunk.add(map(record))
                if (chunk.size >= chunkSize) {
                    persist(chunk)
                    total += chunk.size
                    log.info("{}: imported {} records", javaClass.simpleName, total)
                    chunk = mutableListOf()
                }
            }

            if (chunk.isNotEmpty()) {
                persist(chunk)
                total += chunk.size
            }
            log.info("{}: finished, total {} records", javaClass.simpleName, total)
        }
    }

    protected abstract fun map(record: CSVRecord): T

    protected abstract fun persist(items: List<T>)

    private fun openReader() =
        if (resource.startsWith("classpath:")) {
            val path = resource.removePrefix("classpath:")
            val stream = Thread.currentThread().contextClassLoader.getResourceAsStream(path)
                ?: throw IllegalArgumentException("Classpath resource not found: $path")
            InputStreamReader(stream, StandardCharsets.UTF_8)
        } else {
            Files.newBufferedReader(Path.of(resource), StandardCharsets.UTF_8)
        }
}
