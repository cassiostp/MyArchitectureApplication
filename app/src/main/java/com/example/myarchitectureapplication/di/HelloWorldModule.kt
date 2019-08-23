package com.example.myarchitectureapplication.di

import androidx.lifecycle.ViewModel
import com.example.myarchitectureapplication.feature.hello_world.HelloWorldFragment
import com.example.myarchitectureapplication.feature.hello_world.HelloWorldViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HelloWorldModule {

    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun helloWorldFragment(): HelloWorldFragment

    @Binds
    @IntoMap
    @ViewModelKey(HelloWorldViewModel::class)
    abstract fun bindViewModel(viewmodel: HelloWorldViewModel): ViewModel
}