package jp.demo.domain.employee

import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import jp.demo.infrastructure.entity.EmployeeExtractExecution
import jp.demo.infrastructure.mapper.EmployeeExtractExecutionMapper
import jp.demo.infrastructure.mapper.EmployeeMapper
import org.springframework.stereotype.Repository
import java.io.ByteArrayOutputStream
import java.io.File
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

@Repository
class EmployeeRepository(
    private val mapper: EmployeeMapper,
    private val employeeExtractExecutionMapper: EmployeeExtractExecutionMapper,
) {
    fun selectAll(): List<Employee> {
        return mapper.selectAll().map { Employee(it) }
    }

    fun insertStatus(employee: Employee, status: Status) {
        employeeExtractExecutionMapper.insertEmployeeExtractExecution(
            EmployeeExtractExecution(employee.id, status.name, LocalDate.now(), LocalDate.now()))
    }

    fun selectAllStatus(): List<EmployeeExtractExecution> {
        return employeeExtractExecutionMapper.selectAll()
    }

    @JsonPropertyOrder(
        "id",
        "lastName",
        "firstName",
        "age",
        "birthday",
        "rank",
        "rate",
    )
    private data class OutputEmployee(
        val id: Int,
        val lastName: String,
        val firstName: String,
        val age: Int,
        val birthday: String,
        val rank: String,
        val rate: Int,
    )
    fun archiveCsv(data: List<Employee>) {
        // C:\Users\xxxxx\AppData\Local\Temp\demoBatch_xxxxxxxx.csv
        File.createTempFile("demoBatch_", ".csv")
            .apply {
                writeBytes(writeCsvValueAsByte(data.map { OutputEmployee(
                    it.id,
                    it.name.lastName,
                    it.name.firstName,
                    it.age,
                    it.birthday.format(
                        DateTimeFormatter.ofPattern("yyyy/MM/dd")
                    ),
                    it.rank.name,
                    it.rate,
                ) }))
            }
    }

    private inline fun <reified T> writeCsvValueAsByte(data: Collection<T>): ByteArray {
        val csvMapper = CsvMapper()
        return csvMapper.writer(csvMapper.schemaFor(T::class.java).withHeader())
            .writeValueAsBytes(data)
    }

}