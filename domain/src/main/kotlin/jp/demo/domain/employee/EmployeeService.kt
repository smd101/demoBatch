package jp.demo.domain.employee

import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val repository: EmployeeRepository
) {

    fun extractOverAge(age: Int) {
        val employees = repository.selectAll()
            .filter { it.age > age }
        employees.forEach { println("[select employee]: $it") }

        repository.archiveCsv(employees)

        employees.forEach { repository.insertStatus(it, Status.COMPLETED) }
        repository.selectAllStatus().forEach { println("[select status]: $it") }
    }
}
