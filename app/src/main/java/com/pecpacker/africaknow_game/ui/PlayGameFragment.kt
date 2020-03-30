package com.pecpacker.africaknow_game.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.pecpacker.africaknow_game.API.GameService
import com.pecpacker.africaknow_game.API.Gamesdata
import com.pecpacker.africaknow_game.Answer
import com.pecpacker.africaknow_game.Question
import com.pecpacker.africaknow_game.QuestionData
import com.pecpacker.africaknow_game.R
import com.pecpacker.africaknow_game.databinding.FragmentPlayGameBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */


class PlayGameFragment : Fragment() {

    private lateinit var binding: FragmentPlayGameBinding
    private lateinit var questionData: QuestionData
    private lateinit var questions: MutableList<String>
    lateinit var answer: MutableList<Answer>
    private  var questionsFromApi: MutableList<Question>? = null
    var  currentQuestion: Question? = null
    var questionIndex = 0
    var answerIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate( inflater,R.layout.fragment_play_game,container, false)
        binding.game = this

        getQuestions()
//         val numQuestion = Math.min((questionsFromApi?.size?.plus(1)!!)/2,10)

        val checkedId = binding.radioGroup.checkedRadioButtonId
        if (-1 != checkedId){
            var answerIndex = 0
            when(checkedId){
                R.id.secondAnswerRadioButton -> answerIndex = 1
                R.id.thirdAnswerRadioButton -> answerIndex = 2
                R.id.fourthAnswerRadioButton -> answerIndex = 3
            }

            if (answer[answerIndex].option.equals(true)){
                questionIndex++

                if (questionIndex < 10){
                    currentQuestion = questionsFromApi?.get(questionIndex)!!
                    setQuestion()
                    binding.invalidateAll()
                }else{

                }
            }
        }

        getQuestions()



        return binding.root

    }

    private fun getQuestions(){
        val service = GameService.getRetrofitInstance()?.create(Gamesdata::class.java)
        val call: Call<QuestionData> = service!!.getAllQuestions()
        call.enqueue(object : Callback<QuestionData> {
            var questionList = mutableListOf<Question>()
            var answerlist: MutableList<List<Answer>> = mutableListOf()

            override fun onResponse(call: Call<QuestionData>, response: Response<QuestionData>) {
                if (response.isSuccessful) {
                    questionData = response.body()!!
//                    Log.d("questionList", "response " + questionData.questions.toString())

                    for (question in questionData.questions) {

                        questionList.add(question)
                        answerlist.add(question.answers)
//                        Log.d("questionList", "response " + questions.toString())

                    }
                    questionsFromApi = questionList
                    randomizeQuestion()
//                    questions = questionList
                }

            }

            override fun onFailure(call: Call<QuestionData>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })

    }

    private fun randomizeQuestion(){
        questionsFromApi?.shuffle()
        questionIndex = 0
        setQuestion()

    }


    private fun setQuestion() {
       currentQuestion = questionsFromApi?.get(questionIndex)!!
         answer = currentQuestion?.answers?.toMutableList()!!
        Log.d("no Question", "Questions + ${currentQuestion?.question}")
        binding.textViewQuestion.text = currentQuestion?.question
        answer.shuffle()
        binding.firstAnswerRadioButton.text = answer[0].option
        binding.secondAnswerRadioButton.text = answer[1].option
        binding.thirdAnswerRadioButton.text = answer[2].option
        binding.fourthAnswerRadioButton.text = answer[3].option


    }
}
