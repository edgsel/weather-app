package usr.edgsel.weatherapiclient.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class WeatherRequestDTO(
    val params: Map<String, String>
) {
    constructor(): this(mutableMapOf())
}

