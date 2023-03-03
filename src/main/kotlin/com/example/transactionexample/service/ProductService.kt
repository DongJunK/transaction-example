package com.example.transactionexample.service

import com.example.transactionexample.entity.Product
import com.example.transactionexample.repository.ProductRepository
import com.example.transactionexample.util.CoroutineTransactionHandler
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val transactionHandler: CoroutineTransactionHandler,
    private val productRepository: ProductRepository,
) {
    suspend fun createProduct(product: Product) {
        transactionHandler.run {
            productRepository.save(product)
        }
    }
}