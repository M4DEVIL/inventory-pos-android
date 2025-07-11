package com.example.inventorypos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TransactionDao {
    @Insert
    suspend fun insert(transaction: Transaction)

    @Update
    suspend fun update(transaction: Transaction)

    @Query("SELECT * FROM transactions WHERE timestamp >= :start AND timestamp < :end")
    suspend fun getByDateRange(start: String, end: String): List<Transaction>

    @Query("SELECT * FROM transactions WHERE strftime('%Y-%m-%d', timestamp) = :date")
    suspend fun getByDay(date: String): List<Transaction>
}