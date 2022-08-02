package jp.demo.infrastructure.entity

import java.time.LocalDate

data class Employee(
    var id: Int,
    var name: String,
    var birthday: LocalDate,
    var rank: String,
    var rate: Int,
)
