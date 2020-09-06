package com.app.gadspractice.Koin

import android.app.Application
import android.content.Context
import com.app.gadspractice.Network.GadsApi
import com.app.gadspractice.Repository.ApiRepository
import com.app.gadspractice.ViewModel.ApiViewModel
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule= module {
    viewModel {
        ApiViewModel(get())
    }
}

val retrofitServiceModule = module {
fun provideRetrofitService(retrofit: Retrofit):GadsApi{
    return retrofit.create(GadsApi::class.java)
}
    single { provideRetrofitService(get()) }
}
    val netWork= module {
        fun provideCache(application: Application): Cache {
            val cacheSize = (10 * 1024 * 1024).toLong()
            return Cache(application.cacheDir, cacheSize.toLong())
        }

        fun provideHttpClient(cache: Cache, context: Context): OkHttpClient {
            return OkHttpClient.Builder().cache(cache).build()

        }

        fun provideGson(): Gson {
            return GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create()
        }

        fun provideRetrofit(factory: Gson, client: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                //For making HTTP requests Retrofit uses OkHttp Library
                .baseUrl("https://gadsapi.herokuapp.com")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(factory))
                .client(client)
                .build()
        }
        single { provideHttpClient(get(),get()) }
        single { provideGson() }
        single { provideRetrofit(get(), get()) }
        single { provideCache(androidApplication()) }
    }
val repositoryModule= module {
    fun provideUserRepository(api: GadsApi): ApiRepository {
        return ApiRepository(api)
    }
    single { provideUserRepository(get())}
}

