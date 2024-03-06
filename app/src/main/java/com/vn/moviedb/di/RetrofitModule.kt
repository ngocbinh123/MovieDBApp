/*
 * Copyright 2023 Vincent Tsen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vn.moviedb.di

import com.google.gson.GsonBuilder
import com.vn.moviedb.BuildConfig
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.scope.Scope
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIMEOUT_DURATION = 30L

val retrofitModule =
    module {
        single { Cache(androidContext().cacheDir, 10L * 1024 * 1024) }
        single { GsonBuilder().create() }
        single { retrofitHttpClient() }
        single { retrofitBuilder() }
        single {
            Interceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().apply {
                        header("Accept", "application/json")
                        header("Authorization", "Bearer ${BuildConfig.API_KEY}")
                    }.build(),
                )
            }
        }
    }

private fun Scope.retrofitBuilder(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create(get()))
        .client(get())
        .build()
}

private fun Scope.retrofitHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().apply {
        cache(get())
        connectTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        writeTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        readTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        retryOnConnectionFailure(true)
        addInterceptor(
            HttpLoggingInterceptor().apply {
                level =
                    if (BuildConfig.DEBUG) {
                        HttpLoggingInterceptor.Level.HEADERS
                    } else {
                        HttpLoggingInterceptor.Level.NONE
                    }
            },
        )
    }.build()
}
