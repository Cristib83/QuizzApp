package com.aplication.quizapp_cristi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aplication.quizapp_cristi.databinding.ActivityResoultBinding

private  lateinit var binding: ActivityResoultBinding

class ResoultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResoultBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val username= intent.getStringExtra(Constants.USER_NAME)
        binding.tvName.text = username


        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTION, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWER, 0)
         binding.tvScore.text = "Your score is $correctAnswer out of $totalQuestion"


        window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.btnFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}