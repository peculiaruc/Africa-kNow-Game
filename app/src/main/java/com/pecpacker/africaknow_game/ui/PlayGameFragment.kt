package com.pecpacker.africaknow_game.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pecpacker.africaknow_game.API.GameService
import com.pecpacker.africaknow_game.API.Gamesdata
import com.pecpacker.africaknow_game.Answer
import com.pecpacker.africaknow_game.Question
import com.pecpacker.africaknow_game.QuestionData
import com.pecpacker.africaknow_game.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */


class PlayGameFragment : Fragment() {

    private lateinit var questionData: QuestionData
    private lateinit var questions: MutableList<Question>
    var questionIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_play_game, container, false)
        val questionTextView = root.findViewById<TextView>(R.id.textView_question)
        val service = GameService.getRetrofitInstance()?.create(Gamesdata::class.java)
        val call: Call<QuestionData> = service!!.getAllQuestions()
        call.enqueue(object : Callback<QuestionData> {
            var questionList = mutableListOf<Question>()
            override fun onResponse(call: Call<QuestionData>, response: Response<QuestionData>) {
                if (response.isSuccessful) {
                    questionData = response.body()!!
//                    Log.d("questionList", "response " + questionData.questions.toString())

                    for (question in questionData.questions) {
                        questionList?.add(question)
//                        Log.d("questionList", "response " + questions.toString())
                    }
                    questions = questionList
                }

            }

            override fun onFailure(call: Call<QuestionData>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }


        })




        return root

    }

    private fun randomizeQuestion(){
        questions.shuffle()
        questionIndex = 0
        setQuestion()

    }

    private fun setQuestion() {
        val questionName = arrayListOf<String>()
        val answer = arrayListOf<List<Answer>>()
        val answerList = questions.filterIsInstance<List<Answer>>()

        for (question in questions)
            questionName.add(question.question)

    }

}
