package com.aplication.quizapp_cristi

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.aplication.quizapp_cristi.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int= 0
    private var mCorrectAnswer: Int = 0
    private var mUserName: String? = null


    private lateinit var binding: ActivityQuizQuestionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = ActivityQuizQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()

        setQuestion()

        binding.tvOptionOne.setOnClickListener(this)
        binding.tvOptionTwo.setOnClickListener(this)
        binding.tvOptionThree.setOnClickListener(this)
        binding.tvOptionFour.setOnClickListener(this)


        binding.btnSubmit.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_optionOne ->{
                selectedOptionView(binding.tvOptionOne, 1)
            }

            R.id.tv_optionTwo->{
                selectedOptionView(binding.tvOptionTwo, 2)
            }

            R.id.tv_optionThree->{
                selectedOptionView(binding.tvOptionThree, 3)
            }

            R.id.tv_optionFour->{
                selectedOptionView(binding.tvOptionFour, 4)
            }

            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition ++
                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, ResoultActivity::class.java)
                                intent.putExtra(Constants.USER_NAME, mUserName)
                                intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswer)
                                intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList!!.size)
                               startActivity(intent)

                               finish()

                        }
                    }

                }else {
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_boorder)
                    }else{
                        mCorrectAnswer ++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_boorder)

                  if (mCurrentPosition == mQuestionList!!.size){
                      binding.btnSubmit.text = "Finish"
                  }else{
                      binding.btnSubmit.text = "GO TO NEXT QUESTION"
                  }
                  mSelectedOptionPosition  = 0
                }

            }
        }

    }

    private fun setQuestion (){

        val question = mQuestionList!!.get(mCurrentPosition- 1)

        defaultOptionView()

        if (mCurrentPosition == mQuestionList!!.size){
            binding.btnSubmit.text = "FINISH"
        }else{
            binding.btnSubmit.text = "SUBMIT"
        }

        binding.progressBar.progress = mCurrentPosition
        binding.tvProgress.text = "$mCurrentPosition" +"/" + binding.progressBar.max

        binding.tvQuestion.text = question.question
        binding.ivFlag.setImageResource(question.image)

        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour
    }

    private fun answerView(answer: Int, drawableView: Int){

        when(answer){
            1 -> {binding.tvOptionOne.background= ContextCompat.getDrawable(
                this, drawableView)
            }
            2 -> {binding.tvOptionTwo.background= ContextCompat.getDrawable(
                this, drawableView)
            }
            3 -> {binding.tvOptionThree.background= ContextCompat.getDrawable(
                this, drawableView)
            }
            4 -> {binding.tvOptionFour.background= ContextCompat.getDrawable(
                this, drawableView)
            }
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNumber: Int){
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(this, R.drawable.selected_option_boorder)

    }

    private fun defaultOptionView(){
        val option =ArrayList<TextView>()
        option.add(0, binding.tvOptionOne)
        option.add(1, binding.tvOptionTwo)
        option.add(2, binding.tvOptionThree)
        option.add(3, binding.tvOptionFour)

        for (option in option){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(this, R.drawable.default_option_boorder)
        }
    }
}