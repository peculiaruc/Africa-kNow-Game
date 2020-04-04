package com.pecpacker.africaknow_game.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pecpacker.africaknow_game.API.GameService
import com.pecpacker.africaknow_game.QuestionData
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Call

private val Nothing.localizedMessage: Unit
    get() {
        TODO("Not yet implemented")
    }

class GameViewModel : ViewModel() {

    val disposable = CompositeDisposable()
    val clientService = GameService()


    fun getQuestions(): MutableLiveData<QuestionData> {
        val question: MutableLiveData<QuestionData> = MutableLiveData()

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

private fun Any.subscribe(function: (Nothing) -> Unit, function1: (Nothing) -> Int): Disposable {
    TODO("Not yet implemented")
}

private fun Any.observeOn(mainThread: Scheduler?): Any {
    TODO("Not yet implemented")
}

private fun <T> Call<T>.subscribeOn(io: Scheduler): Any {
    TODO("Not yet implemented")
}
