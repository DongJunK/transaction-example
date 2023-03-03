package com.example.transactionexample.handler.model

import com.example.transactionexample.entity.Product
import com.example.transactionexample.enum.ProductStatusType
import java.time.LocalDateTime

data class ProductCreateRequest(
    val productName: String,
    val amounts: Int,
    val stockCount: Int,
    val productStatusType: ProductStatusType,
) {
    fun toEntity(): Product {
        return Product(
            productName = productName,
            amounts = amounts,
            stockCount = stockCount,
            productStatusType = ProductStatusType.SALE,
            registerDateTime = LocalDateTime.now(),
            updateDateTime = LocalDateTime.now()
        )
    }
}