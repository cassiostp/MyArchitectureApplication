package com.example.myarchitectureapplication.feature.hello_world

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HelloWorldViewModel @Inject constructor() : ViewModel() {
    private val _helloWorldString = MutableLiveData<String>()
    val helloWorldString: LiveData<String> = _helloWorldString

    val newText = MutableLiveData<String>()

    init {
        _helloWorldString.value = "Hello World!"
    }

    fun setHelloWorldText(view: View) {
        _helloWorldString.value = newText.value
    }
}