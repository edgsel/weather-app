package usr.edgsel.weatherapiclient.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class JacksonConfig {

    @Bean
    fun jacksonModuleConfig(): ObjectMapper {
        return jacksonObjectMapper()
            .registerModule(JavaTimeModule())
    }
}
