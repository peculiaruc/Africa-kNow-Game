package com.pecpacker.africaknow_game.Model


data class Question(
    val message: String,
    val questions: List<QuestionX>
)

data class QuestionX(
    val _id: String,
    val answers: List<Answer>,
    val question: String
)

data class Answer(
    val option: String,
    val value: Boolean
)