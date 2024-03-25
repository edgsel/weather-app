package usr.edgsel.weatherapiclient.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import usr.edgsel.weatherapiclient.HelloMessage
import java.time.LocalDateTime

@Controller
class HealthCheckController {

    @Throws(Exception::class)
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    fun getHealthCheck(helloMessage: HelloMessage): Map<String, Any> {
        return mapOf(
            "greeting" to helloMessage.name,
            "time" to LocalDateTime.now()
        )
    }
}
