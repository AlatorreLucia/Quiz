package alatorre.leal.com.example.quiz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import alatorre.leal.com.example.quiz.R

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel(){

    private val questionBank = listOf(

        Question(R.string.question_it, true, 1),
        Question(R.string.question_it, true, 1),
        Question(R.string.question_torre, false, 1),
        Question(R.string.question_cementerio, false, 1),
        Question(R.string.question_cupula, true, 1)
    )
    var currentIndex: Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY,value)

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    var currentStatus
        get() = questionBank[currentIndex].enabled
        set(value){questionBank[currentIndex].enabled = value}


    val getCurrentSize: Int
        get() = questionBank.size

    fun moveToNext(){
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev(){
        currentIndex = (currentIndex - 1) % questionBank.size
    }

}