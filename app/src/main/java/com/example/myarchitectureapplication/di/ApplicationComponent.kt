package com.example.myarchitectureapplication.di

import android.content.Context
import com.example.myarchitectureapplication.MyArchitectureApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        HelloWorldModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MyArchitectureApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}