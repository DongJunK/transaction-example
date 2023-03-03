package com.example.transactionexample.converter

import com.example.transactionexample.enum.ProductStatusType
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class ProductStatusTypeConverter : AttributeConverter<ProductStatusType, String> {
    override fun convertToDatabaseColumn(attribute: ProductStatusType?): String? {
        if (attribute == null) return null
        return attribute.name
    }

    override fun convertToEntityAttribute(dbData: String?): ProductStatusType? {
        if (dbData == null) return null
        return ProductStatusType.values().find { it.name == dbData }
    }
}