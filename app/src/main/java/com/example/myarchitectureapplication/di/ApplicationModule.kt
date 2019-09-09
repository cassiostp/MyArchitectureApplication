package com.example.myarchitectureapplication.di

import android.content.Context
import androidx.room.Room
import com.example.myarchitectureapplication.data.source.DefaultHelloRepository
import com.example.myarchitectureapplication.data.source.HelloDataSource
import com.example.myarchitectureapplication.data.source.local.HelloLocalDataSource
import com.example.myarchitectureapplication.data.source.HelloRepository
import com.example.myarchitectureapplication.data.source.local.MyAppDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
object ApplicationModule{

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class HelloLocalDataSource

    @JvmStatic
    @Singleton
    @HelloLocalDataSource
    @Provides
    fun provideHelloLocalDataSource(
        database: MyAppDatabase,
        ioDispatcher: CoroutineDispatcher
    ): HelloDataSource {
        return HelloLocalDataSource(
            database.helloDao(), ioDispatcher
        )
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideDataBase(context: Context): MyAppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            MyAppDatabase::class.java,
            "Hello.db"
        ).build()
    }

    @JvmStatic
    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}

@Module
abstract class ApplicationModuleBinds {

    @Singleton
    @Binds
    abstract fun bindRepository(repo: DefaultHelloRepository): HelloRepository
}