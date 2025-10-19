package com.alfons.nmpspongebobquiz

import android.content.SharedPreferences
import android.os.Bundle
import android.os.SharedMemory
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.content.Intent
import com.alfons.nmpspongebobquiz.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    var highScore = 0
    var score = 0
    companion object{
        val SCORE = "score"
        var HIGH_SCORE = "highScore"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //var highScore = this.intent.getIntExtra(MainActivity.SCORE, 0)

        //Definisikan nama filenya dulu
        var sharedFile = packageName

        // creating/accessing the SharedPreferences object
        var shared: SharedPreferences = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        score = shared.getInt(SCORE, 0)
        highScore = shared.getInt(HIGH_SCORE, 0)

        if(highScore < score) {
            highScore = score
            val editor = shared.edit()
            editor.putInt(HIGH_SCORE, highScore)
            editor.apply()
        }
        binding.txtHighScore.text = highScore.toString()
        binding.txtScore.text = score.toString()

        binding.btnReplay.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}