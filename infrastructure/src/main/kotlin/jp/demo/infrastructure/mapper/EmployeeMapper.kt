package jp.demo.infrastructure.mapper

import jp.demo.infrastructure.entity.Employee
import org.apache.ibatis.annotations.Mapper

@Mapper
interface EmployeeMapper {
    fun selectAll(): List<Employee>
    fun updateAge(employee: Employee)
}
