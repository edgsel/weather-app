package usr.edgsel.weatherapiclient.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class HealthCheckController {

    @MessageMapping("/health-check")
    @SendTo("/topic/health-check")
    fun getHealthCheck(): Map<String, Boolean> {
        return mapOf("ok" to true)
    }
}
