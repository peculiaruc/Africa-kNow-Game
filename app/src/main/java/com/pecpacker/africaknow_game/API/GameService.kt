package com.pecpacker.africaknow_game.API

import com.pecpacker.africaknow_game.QuestionData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GameService {
//    val BASE_URL = "https://quizzies.herokuapp.com/"


    companion object {
        val BASE_URL = "https://quizzies.herokuapp.com/"
        var retrofit: Retrofit? = null
        fun getRetrofitInstance(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            }
            return retrofit
        }

    }


    private val questionsApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(Gamesdata::class.java)

    fun getQuestions(): Call<QuestionData> {
        return questionsApi.getAllQuestions()
    }
}