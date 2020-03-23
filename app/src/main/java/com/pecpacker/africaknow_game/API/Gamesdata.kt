package com.pecpacker.africaknow_game.API

import androidx.room.Dao
import com.pecpacker.africaknow_game.Model.GameModel
import io.reactivex.Single
import retrofit2.http.GET

@Dao
interface Gamesdata {
    @GET("quizes/")
    fun getAllQuestions() : Single<List<GameModel>>

}