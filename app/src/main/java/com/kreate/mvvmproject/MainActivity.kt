package com.kreate.mvvmproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.kreate.mvvmproject.apis.Status
import com.kreate.mvvmproject.apis.Status.*
import com.kreate.mvvmproject.entity.RequestEntity

class MainActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels {
        InjectorUtils.provideLoginViewModelFactory()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val requestEntity = RequestEntity().apply {
            this.Region = "VSPL"
            this.Section_Code = "22200102"
            this.Pipeline_Code = "22200100"
        }

        viewModel.getFetchData(requestEntity).observe(this, { it ->
            it?.let { resource ->
                when(resource.status){
                    SUCCESS ->{
                        Log.e("TAG","SUCCESS")
                        if(!isFinishing){
                            resource.data?.let {
                                if(it.type.isNotBlank() && it.type.equals("true", true)){

                                }else{
                                    isSnackBar(this, "Success ${it.message}")
                                }
                            }
                        }
                    }
                    ERROR ->{
                        isSnackBar(this, "ERROR ${it.message}")
                    }
                    LOADING ->{
                        Log.e("TAG","LOADING ${it.message}")
                    }
                }
            }
        })
    }
}