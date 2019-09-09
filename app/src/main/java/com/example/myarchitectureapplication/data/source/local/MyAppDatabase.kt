package com.example.myarchitectureapplication.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myarchitectureapplication.data.source.Hello

@Database(entities = [Hello::class], version = 1, exportSchema = true)
abstract class MyAppDatabase : RoomDatabase() {
    abstract fun helloDao(): HelloDao
}