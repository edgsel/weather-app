package usr.edgsel.weatherapiclient.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .headers()
            .frameOptions().sameOrigin()
            .and()
            .authorizeRequests()
            .requestMatchers("/websocket/**", "/app/**").permitAll() // Permit access to WebSocket endpoints
            .anyRequest().authenticated()
            .and()
            .httpBasic()
            .and()
            .csrf().disable().build() // Disable CSRF for WebSocket
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val config = CorsConfiguration().also {
            it.allowedOrigins = listOf("*")
            it.allowCredentials = true
            it.allowedMethods = listOf("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH")
            it.allowedHeaders = listOf("Authorization", "Cache-Control", "Content-Type")
        }

        return UrlBasedCorsConfigurationSource()
            .apply { registerCorsConfiguration("/**", config) }
    }
}
