package com.alfons.nmpspongebobquiz

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.alfons.nmpspongebobquiz.databinding.ActivityNewQuestionBinding

class NewQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        }
    }