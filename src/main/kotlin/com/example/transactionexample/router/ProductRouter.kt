package com.example.transactionexample.router

import com.example.transactionexample.handler.ProductHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class ProductRouter(
    private val productHandler: ProductHandler,
) {
    @Bean
    fun routeProduct(): RouterFunction<ServerResponse> = coRouter {
        (accept(MediaType.APPLICATION_JSON) and "/products").nest {
            POST("", productHandler::createProduct)
        }
    }
}