package com.example.myarchitectureapplication.data.source

import com.example.myarchitectureapplication.data.Hello
import com.example.myarchitectureapplication.data.Result

interface HelloDataSource {

    suspend fun getHellos(): Result<List<Hello>>

    suspend fun getHello(helloId: String): Result<Hello>

    suspend fun saveHello(hello: Hello)
}