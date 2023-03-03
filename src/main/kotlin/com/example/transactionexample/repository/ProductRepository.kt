package com.example.transactionexample.repository

import com.example.transactionexample.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Int> {
    override fun findAll(): List<Product>
}