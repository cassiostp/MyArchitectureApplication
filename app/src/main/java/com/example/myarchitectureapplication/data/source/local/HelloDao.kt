package com.example.myarchitectureapplication.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myarchitectureapplication.data.source.Hello

@Dao
interface HelloDao {
    @Query("SELECT * FROM hello")
    suspend fun getHello(): List<Hello>

    @Query("SELECT * FROM hello WHERE entryId = :helloId")
    suspend fun getHelloById(helloId: String): Hello?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHello(hello: Hello)
}