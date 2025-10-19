package com.alfons.nmpspongebobquiz

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.alfons.nmpspongebobquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            displayQuestions()

            binding.btnTrue.setOnClickListener {
                binding.txtQuestion.text = "NMPSpongebobQuizes";
            }
        }

        var pertanyaanSkrg = 0
        fun displayQuestions() {
            binding.txtQuestion.text = BankSoal.pertanyaannya[pertanyaanSkrg].soal
        }


}