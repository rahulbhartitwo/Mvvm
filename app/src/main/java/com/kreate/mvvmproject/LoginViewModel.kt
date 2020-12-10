package com.kreate.mvvmproject

import androidx.lifecycle.*
import com.kreate.mvvmproject.apis.AuthRepository
import com.kreate.mvvmproject.apis.Resource
import com.kreate.mvvmproject.entity.RequestEntity
import kotlinx.coroutines.Dispatchers
import org.json.JSONException

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {

    fun getFetchData(requestEntity: RequestEntity) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getFetchData(requestEntity)))
        }
        catch (e : JSONException){
            emit(Resource.error(data = null, message = e.message ?: "JSON Error Occurred!"))
        }
        catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occurred!"))
        }
    }
}