package usr.edgsel.weatherapiclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WeatherApiClientApplication

fun main(args: Array<String>) {
	runApplication<WeatherApiClientApplication>(*args)
}
