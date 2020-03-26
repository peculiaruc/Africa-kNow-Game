package com.pecpacker.africaknow_game.ViewModel

import androidx.lifecycle.ViewModel
import com.pecpacker.africaknow_game.API.GameService
import io.reactivex.disposables.CompositeDisposable

class GameViewModel : ViewModel() {

    val disposable = CompositeDisposable()
    val clientService = GameService()


//    fun getQuestions(): MutableLiveData<QuestionData> {
//        val question: MutableLiveData<QuestionData> = MutableLiveData()
//
//        disposable.add(
//            clientService.getQuestions()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                    //onSuccess
//                    { gameModel ->
//                        question.value = gameModel
//                    },
//                    //onFailure
//                    { error ->
//                        Log.e("ViewModelError", " ${error.localizedMessage}")
//                    }
//
//                )
//        )
//        return question
//    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }



}