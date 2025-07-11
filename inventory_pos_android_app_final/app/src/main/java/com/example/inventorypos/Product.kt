package com.example.inventorypos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey val barcode: String,
    val name: String,
    val buyingPrice: Double,
    val sellingPrice: Double,
    val margin: Double = 0.0,
    val stock: Int = 0
)