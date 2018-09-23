package br.com.dalcim.marvel.module

import br.com.dalcim.marvel.BuildConfig
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.applicationContext
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.math.BigInteger
import java.security.MessageDigest
import java.util.concurrent.TimeUnit

private const val BASE_URL = "BASE_URL"
private const val READ_TIME_OUT = "READ_TIME_OUT"
private const val CONNECT_TIME_OUT = "CONNECT_TIME_OUT"
private const val HEADER_INTERCEPTOR = "HEADER_INTERCEPTOR"
private const val QUERY_INTERCEPTOR = "QUERY_INTERCEPTOR"
private const val LOGGER_INTERCEPTOR = "LOGGER_INTERCEPTOR"

val retrofitClientModule = applicationContext {
    bean(BASE_URL) { "http://gateway.marvel.com/v1/public/" }
    bean(READ_TIME_OUT) { 60 }
    bean(CONNECT_TIME_OUT) { 60 }

    factory {
        Retrofit.Builder()
                .baseUrl(get<String>(BASE_URL))
                .client(/* OkHttpClient */ get())
                .addConverterFactory(/*Converter.Factory*/ get())
                .build()
    }

    bean {
        OkHttpClient.Builder()
                .connectTimeout(get(CONNECT_TIME_OUT), TimeUnit.SECONDS)
                .readTimeout(get(READ_TIME_OUT), TimeUnit.SECONDS)
                .addInterceptor(get(HEADER_INTERCEPTOR))
                .addInterceptor(get(QUERY_INTERCEPTOR))
                .addInterceptor(get(LOGGER_INTERCEPTOR))
                .build() as OkHttpClient
    }

    bean(HEADER_INTERCEPTOR) {
        Interceptor { chain ->
            chain.proceed(chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .build())
        }
    }

    bean(QUERY_INTERCEPTOR) {
        Interceptor { chain ->
            val originalRequest = chain.request()

            val timeStamp = System.currentTimeMillis()

            val url = originalRequest.url().newBuilder()
                    .addQueryParameter("apikey", BuildConfig.PUBLIC_KEY)
                    .addQueryParameter("hash", "$timeStamp${BuildConfig.PRIVATE_KEY}${BuildConfig.PUBLIC_KEY}".toMd5())
                    .addQueryParameter("ts", "$timeStamp")
                    .build()

            val request = originalRequest
                    .newBuilder()
                    .url(url)
                    .build()
            chain.proceed(request)
        }
    }

    bean(LOGGER_INTERCEPTOR) {
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
    }

    bean { GsonConverterFactory.create(/* Gson */ get()) as Converter.Factory }

    bean {
        Gson()
    }
}

private fun String.toMd5(): String {
    val md5 = BigInteger(1, MessageDigest.getInstance("MD5").digest(this.toByteArray())).toString(16)
    return "0" * (32 - md5.length) + md5
}

private operator fun String.times(i: Int) = (1..i).fold("") { acc, _ -> acc + this }