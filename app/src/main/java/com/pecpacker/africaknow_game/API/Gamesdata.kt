package com.pecpacker.africaknow_game.API

import androidx.room.Dao
import com.pecpacker.africaknow_game.QuestionData
import retrofit2.Call
import retrofit2.http.GET

@Dao
interface Gamesdata {
    @GET("quizes/")
    fun getAllQuestions(): Call<QuestionData>

}