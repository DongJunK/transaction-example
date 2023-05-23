package com.example.transactionexample.transaction

import com.example.transactionexample.entity.Product
import com.example.transactionexample.enum.ProductStatusType
import com.example.transactionexample.repository.ProductRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@DataJpaTest
class TransactionTest {
    @Autowired
    private lateinit var productRepository: ProductRepository

    private val product = Product(
        productNo = 1,
        productName = "상품",
        amounts = 1000,
        stockCount = 1,
        productStatusType = ProductStatusType.SALE,
        registerDateTime = LocalDateTime.now(),
        updateDateTime = LocalDateTime.now(),
    )

    @Test
    fun test() {
        saveProduct()
        val productForCheck = productRepository.findByProductNo(product.productNo)
        assertEquals(product.productNo, productForCheck.productNo)
        assertEquals(product.productName, productForCheck.productName)
        assertEquals(product.amounts, productForCheck.amounts)
    }

    @Transactional
    fun saveProduct() {
        productRepository.save(product)
    }
}