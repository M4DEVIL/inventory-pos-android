package com.example.inventorypos

import androidx.room.*

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Update
    suspend fun update(product: Product)

    @Query("SELECT * FROM products WHERE barcode = :barcode")
    suspend fun getByBarcode(barcode: String): Product?

    @Query("SELECT * FROM products")
    suspend fun getAll(): List<Product>
}