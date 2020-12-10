package com.kreate.mvvmproject.apis

import com.kreate.mvvmproject.entity.RequestEntity
import com.kreate.mvvmproject.entity.ResponseEntity
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url
import java.util.concurrent.TimeUnit

interface ApiCall {

    @GET()
    suspend fun getCountry(@Url string: String): List<String>

//    @GET("api/users")
//    suspend fun getListData(@Query("page") pageNumber: Int): PaggingEntity

    @POST("api/LineInformation/GetVulnerableLocation")
    suspend fun getFetchData(@Body requestEntity: RequestEntity): ResponseEntity

    companion object {
        const val BASE_URL = "http://14.142.224.133:1080/gailapi-dev/"

        fun create(): ApiCall {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(object : Interceptor {
                    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                        val requestBuilder: Request.Builder = chain.request().newBuilder()
//           todo             requestBuilder.header("Authorization", "serverKey")
                        requestBuilder.header("Content-Type", "application/json")
                        return chain.proceed(requestBuilder.build())
                    }
                })
                .build()

            return Retrofit.Builder()
                .baseUrl(
                    BASE_URL
                )
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiCall::class.java)
        }
    }
}
