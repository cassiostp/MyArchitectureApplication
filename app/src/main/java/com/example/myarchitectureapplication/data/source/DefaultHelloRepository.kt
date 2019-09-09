package com.example.myarchitectureapplication.data.source

import com.example.myarchitectureapplication.data.Hello
import com.example.myarchitectureapplication.data.Result
import com.example.myarchitectureapplication.data.Result.*
import com.example.myarchitectureapplication.di.ApplicationModule.HelloLocalDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultHelloRepository @Inject constructor(
    @HelloLocalDataSource private val helloLocalDataSource: HelloDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): HelloRepository {
    override suspend fun getHello(helloId: String): Result<Hello> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun saveHello(hello: Hello) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getHellos(): Result<List<Hello>> {
        return withContext(ioDispatcher) {
            val hellos = fetchHellosFromLocal()
            (hellos as? Success)?.let {
                return@withContext (Success(it.data))
            }
            return@withContext Error(Exception("Illegal state"))
        }
    }

    private suspend fun fetchHellosFromLocal(): Result<List<Hello>> {
        val localHellos = helloLocalDataSource.getHellos()
        if (localHellos is Success) return localHellos
        return Error(Exception("Error fetching from local"))
    }
}