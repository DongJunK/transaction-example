package com.example.transactionexample.entity

import com.example.transactionexample.converter.ProductStatusTypeConverter
import com.example.transactionexample.enum.ProductStatusType
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var productNo: Int = 0,
    val productName: String,
    val amounts: Int,
    val stockCount: Int,
    @Convert(converter = ProductStatusTypeConverter::class)
    val productStatusType: ProductStatusType,
    val registerDateTime: LocalDateTime,
    val updateDateTime: LocalDateTime,
)
