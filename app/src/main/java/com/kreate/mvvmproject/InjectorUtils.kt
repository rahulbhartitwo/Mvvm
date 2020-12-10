package com.kreate.mvvmproject

import com.kreate.mvvmproject.apis.ApiCall
import com.kreate.mvvmproject.apis.AuthRepository

object InjectorUtils {

    fun provideLoginViewModelFactory() : LoginViewModelFactory{
        val authRepository = AuthRepository(api = ApiCall.create())
        return LoginViewModelFactory(authRepository)
    }



}