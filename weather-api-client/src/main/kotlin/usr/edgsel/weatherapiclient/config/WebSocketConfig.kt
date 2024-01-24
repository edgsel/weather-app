package usr.edgsel.weatherapiclient.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer

@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfig : WebSocketMessageBrokerConfigurer {

    @Bean
    fun heartBeatScheduler() : TaskScheduler {
        return ThreadPoolTaskScheduler()
    }
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        registry.enableSimpleBroker(BROKER_DESTINATION_PREFIX)
            .setHeartbeatValue(longArrayOf(5000, 5000))
            .setTaskScheduler(heartBeatScheduler())

        registry.setApplicationDestinationPrefixes(APP_DESTINATION_PREFIX)
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry
            .addEndpoint(WEBSOCKET_ENDPOINT_PATH)
            .setAllowedOrigins("*")

        registry
            .addEndpoint(WEBSOCKET_ENDPOINT_PATH)
            .setAllowedOrigins("*")
            .withSockJS()
    }

    companion object {
        const val BROKER_DESTINATION_PREFIX = "/topic"
        const val APP_DESTINATION_PREFIX = "/app"
        const val WEBSOCKET_ENDPOINT_PATH = "/websocket"
    }
}
