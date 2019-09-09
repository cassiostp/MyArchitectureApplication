package com.example.myarchitectureapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "hello")
data class Hello(
    @ColumnInfo(name = "value") var value: String = "",
    @ColumnInfo(name = "modified") var modified: Boolean = false,
    @PrimaryKey @ColumnInfo(name = "entryId") var id: String = UUID.randomUUID().toString()
)