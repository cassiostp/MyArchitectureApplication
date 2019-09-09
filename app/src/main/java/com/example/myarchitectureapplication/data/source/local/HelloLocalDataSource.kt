package com.example.myarchitectureapplication.data.source.local

import com.example.myarchitectureapplication.data.Hello
import com.example.myarchitectureapplication.data.Result
import com.example.myarchitectureapplication.data.Result.Success
import com.example.myarchitectureapplication.data.Result.Error
import com.example.myarchitectureapplication.data.source.HelloDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class HelloLocalDataSource internal constructor(
    private val helloDao: HelloDao,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : HelloDataSource {

    override suspend fun getHellos(): Result<List<Hello>> = withContext(ioDispatcher) {
        return@withContext try {
            Success(helloDao.getHello())
        } catch (e: Exception) {
            Error(e)
        }
    }

    override suspend fun getHello(helloId: String): Result<Hello> = withContext(ioDispatcher) {
        try {
            val hello = helloDao.getHelloById(helloId)
            if (hello != null) {
                return@withContext Success(hello)
            } else {
                return@withContext Error(Exception("hello not found!"))
            }
        } catch (e: Exception) {
            return@withContext Error(e)
        }
    }

    override suspend fun saveHello(hello: Hello) = withContext(ioDispatcher) {
        helloDao.insertHello(hello)
    }
}