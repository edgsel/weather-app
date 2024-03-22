package usr.edgsel.weatherapiclient.client

import org.springframework.stereotype.Service
import usr.edgsel.weatherapiclient.util.URLParamsBuilder
import java.util.logging.Logger
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

@Service
class WeatherApiClient {

    val logger: Logger = Logger.getLogger(WeatherApiClient::class.simpleName)

    val httpClient: HttpClient = HttpClient.newHttpClient()

    fun getWeatherForecast(params: Map<String, Any>): String {
        val requestUrl = "$WEATHER_API_URL?${URLParamsBuilder.build(params)}"

        logger.info("Sending request to $requestUrl")

        return httpClient
            .send(buildRequest(requestUrl), HttpResponse.BodyHandlers.ofString())
            .body()
    }

    private fun buildRequest(url: String): HttpRequest {
        return HttpRequest
            .newBuilder()
            .uri(URI(url))
            .GET()
            .build()
    }

    companion object {
        private const val WEATHER_API_URL = "https://api.open-meteo.com/v1/forecast"
    }
}
