package usr.edgsel.weatherapiclient.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import usr.edgsel.weatherapiclient.client.WeatherApiClient
import usr.edgsel.weatherapiclient.dto.WeatherRequestDTO

@Controller
class WeatherController(
    private val weatherApiClient: WeatherApiClient
) {

    @Throws(Exception::class)
    @MessageMapping("/weather")
    @SendTo("/topic/weather")
    fun getWeatherData(request: WeatherRequestDTO): String {
        return weatherApiClient.getWeatherForecast(request.params)
    }
}
