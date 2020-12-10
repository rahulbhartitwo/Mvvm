package com.kreate.mvvmproject.apis

import com.kreate.mvvmproject.entity.RequestEntity


class AuthRepository(private val api : ApiCall)  {

    suspend fun getFetchData(requestEntity : RequestEntity) =  api.getFetchData(requestEntity = requestEntity)

}