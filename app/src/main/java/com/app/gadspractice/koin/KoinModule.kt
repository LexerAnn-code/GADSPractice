package com.app.gadspractice.koin

import android.app.Application
import android.content.Context
import com.app.gadspractice.network.GadsApi
import com.app.gadspractice.network.GadsSubmitApi
import com.app.gadspractice.repository.ApiRepository
import com.app.gadspractice.repository.RepositorySubmit
import com.app.gadspractice.viewmodel.ApiViewModel
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
        ApiViewModel(get(), get())
    }
}

val repositoryModuleSubmit= module {
    fun provideRetrofitServiceSubmit(retrofit: Retrofit): GadsSubmitApi {
        return retrofit.create(GadsSubmitApi::class.java)

    }
    single { provideRetrofitServiceSubmit(get()) }
}

val repositoryModules= module {
    fun provideRetrofitServiceSubmit(retrofit: Retrofit): GadsApi {
        return retrofit.create(GadsApi::class.java)

    }
    single { provideRetrofitServiceSubmit(get()) }
}
val repositoryModuleApiRepository= module {
    fun provideUserRepository(api: GadsApi): ApiRepository {
        return ApiRepository(api)
    }

    single { provideUserRepository(get())}
}
val repositoryModuleRepositorySubmit= module {
    fun provideUserRepository(api: GadsSubmitApi): RepositorySubmit {
        return RepositorySubmit(api)
    }

    single { provideUserRepository(get())}
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



