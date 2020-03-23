package com.pecpacker.africaknow_game.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pecpacker.africaknow_game.API.GameService
import com.pecpacker.africaknow_game.Model.Question
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GameViewModel : ViewModel() {

    val disposable = CompositeDisposable()
    val clientService = GameService()


    fun getQuestions(): MutableLiveData<Question> {
        val question: MutableLiveData<Question> = MutableLiveData()

        disposable.add(
            clientService.getQuestions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    //onSuccess
                    { gameModel ->
                        question.value = gameModel
                    },
                    //onFailure
                    { error ->
                        Log.e("ViewModelError", " ${error.localizedMessage}")
                    }

                )
        )
        return question
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }



}