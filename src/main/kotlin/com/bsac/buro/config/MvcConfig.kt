package com.bsac.buro.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.view.InternalResourceViewResolver


@Configuration
@EnableWebMvc
class MvcConfig : WebMvcConfigurer {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry
            .addResourceHandler("/resources/static/**")
            .addResourceLocations("/resources/static")
    }

    @Bean
    fun viewResolver(): ViewResolver {
        val resolver = InternalResourceViewResolver()
        resolver.setPrefix("/WEB-INF/jsp/")
        resolver.setSuffix(".jsp")
        return resolver
    }

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/login").setViewName("login")
    }

}