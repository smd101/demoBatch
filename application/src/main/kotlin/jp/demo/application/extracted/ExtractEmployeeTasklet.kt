package jp.demo.application.extracted

import jp.demo.domain.employee.EmployeeService
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Service

@Service
class ExtractEmployeeTasklet(
    private val employeeService: EmployeeService

) : Tasklet {
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus {
        employeeService.extractOverAge(40)

        return RepeatStatus.FINISHED
    }
}
