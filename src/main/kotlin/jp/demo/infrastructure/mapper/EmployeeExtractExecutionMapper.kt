package jp.demo.infrastructure.mapper

import jp.demo.infrastructure.entity.EmployeeExtractExecution
import org.apache.ibatis.annotations.Mapper


@Mapper
interface EmployeeExtractExecutionMapper {
    fun selectAll(): List<EmployeeExtractExecution>
    fun insertEmployeeExtractExecution(entity: EmployeeExtractExecution)
}