package jp.demo.infrastructure.entity

import java.time.LocalDate

data class EmployeeExtractExecution(
    var employeeId: Int,
    var status: String,
    var createTime: LocalDate,
    var lastUpdated: LocalDate,
)
