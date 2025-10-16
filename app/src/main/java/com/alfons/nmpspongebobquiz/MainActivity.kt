package com.alfons.nmpspongebobquiz

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import com.alfons.nmpspongebobquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val txtQuestion = findViewById<TextView>(R.id.txtQuestion);
        val btn = findViewById<Button>(R.id.btnTrue)

        btn.setOnClickListener {
            txtQuestion.text = "SPONGEBOB QUIZ";
        }
    }
}