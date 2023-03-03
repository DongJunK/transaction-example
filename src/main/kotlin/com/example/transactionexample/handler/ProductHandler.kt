package com.example.transactionexample.handler

import com.example.transactionexample.handler.model.ProductCreateRequest
import com.example.transactionexample.service.ProductService
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait

@Component
class ProductHandler(
    private val productService: ProductService,
) {
    suspend fun createProduct(serverRequest: ServerRequest): ServerResponse {
        val request = serverRequest.bodyToMono(ProductCreateRequest::class.java).awaitSingle()

        productService.createProduct(request.toEntity())

        return ServerResponse.noContent().buildAndAwait()
    }
}