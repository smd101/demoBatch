package jp.demo.application.extracted

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing
class ExtractEmployeeBatchConfig (
    private val jobBuilderFactory: JobBuilderFactory,
    private val stepBuilderFactory: StepBuilderFactory,
    private val extractEmployeeTasklet: ExtractEmployeeTasklet,
) {

    @Bean
    fun extractEmployeeStep(): Step {
        return stepBuilderFactory.get("extracted-employee-step")
            .tasklet(extractEmployeeTasklet)
            .build()
    }

    @Bean
    fun job(): Job {
        return jobBuilderFactory.get("extracted-employee-job")
            .start(extractEmployeeStep())
            .build()
    }
}
