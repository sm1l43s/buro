package com.bsac.buro.config

import com.bsac.buro.service.web.CustomUserDetailsService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    private val userDetailsService: CustomUserDetailsService
) {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.invoke {
            csrf { disable() }
            authorizeRequests {
                authorize("/", permitAll)
                authorize("/orders/{id}", permitAll)
                authorize("/orders/remove/{id}", permitAll)
                authorize("/register", permitAll)
                authorize("/h2-console", permitAll)
                authorize("/h2-console/**", permitAll)
                authorize("/swagger-ui/**", permitAll)
                authorize("/orders", hasAnyAuthority("ROLE_MANAGER", "ROLE_ADMIN"))
                authorize("/orders/edit/{id}", hasAnyAuthority("ROLE_MANAGER","ROLE_CONSTRUCTOR", "ROLE_ADMIN"))
                authorize("orderUpdate", hasAnyAuthority("ROLE_MANAGER","ROLE_CONSTRUCTOR", "ROLE_ADMIN"))
                authorize("/constructors", hasAnyAuthority("ROLE_CONSTRUCTOR", "ROLE_ADMIN"))
                authorize("/register", hasAnyAuthority("ROLE_ADMIN"))
                authorize("/users", hasAnyAuthority("ROLE_ADMIN"))
                authorize("/users/**", hasAnyAuthority("ROLE_ADMIN"))
            }
            exceptionHandling {
                accessDeniedPage = "/login"
            }
            formLogin {
                loginPage = "/login"
                loginProcessingUrl = "/login"
                permitAll()
            }

        }
        return http.build()
    }

    @Bean
    fun authenticationManager(): AuthenticationManager {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setPasswordEncoder(passwordEncoder())
        authProvider.setUserDetailsService(userDetailsService)
        return ProviderManager(authProvider)
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}