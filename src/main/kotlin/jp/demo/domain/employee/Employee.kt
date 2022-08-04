package jp.demo.domain.employee

import java.time.LocalDate
import java.time.temporal.ChronoUnit

data class Employee(
    var id: Int,
    var name: Name,
    var birthday: LocalDate,
    var age: Int,
    var rank: Rank,
    var rate: Int,
) {
    constructor(entity: jp.demo.infrastructure.entity.Employee) :
        this(
            entity.id,
            Name(entity.name),
            entity.birthday,
            ChronoUnit.YEARS.between(entity.birthday, LocalDate.now()).toInt(),
            Rank.valueOf(entity.rank),
            entity.rate)

}
