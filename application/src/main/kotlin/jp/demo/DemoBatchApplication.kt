package jp.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoBatchApplication

fun main(args: Array<String>) {
    runApplication<DemoBatchApplication>(*args)
}
